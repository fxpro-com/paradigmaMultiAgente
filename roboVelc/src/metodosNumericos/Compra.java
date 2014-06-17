package metodosNumericos;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.util.leap.Iterator;

public class Compra {
	
	protected void setup(){
		//Criação de um objeto contendo a descrição do serviço a ser buscado
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription buscaServico = new ServiceDescription();
		buscaServico.setType("Tipo1");
		
		//Adiciona o serviço na entrada
		template.addServices(buscaServico);
		
		try {
			//É procurado no array de DFAgentDescription os agentes disponíveis
			DFAgentDescription[] resultado = DFService.search(null,template);
			
			//Impressão dos resultados
			for(int i = 0; i < resultado.length; i++){
				//resultado[i].getName fornece a AID do agente
				String saida = resultado[i].getName().getLocalName() + "provê";
				//Invocar método getAllServices() para obter serviços do agente
				Iterator iter = resultado[i].getAllServices();
				
				while(iter.hasNext()){
					//Extração dos serviços para um objeto ServiceDescription
					ServiceDescription SD = (ServiceDescription) iter.next();
					//Captura o nome do serviço
					saida += "" + SD.getName();
				}
				
				//Impressão dos serviços de cada agente na tela
				System.out.println(saida);
			}
			
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}	
	}
}
