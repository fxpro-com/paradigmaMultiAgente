package metodosNumericos;

import comportamentos.EsperarPedidos;

import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class CorrelacaoAgente extends Agent{

	private static final long serialVersionUID = -7919542083794177881L;
	private double correlacaoLinear = 0.9;
	
	protected void setup(){
		System.out.println("Olá! Sou o analisador "+getLocalName()+" Quero registrar a correlacao!");
		registrarNoDF();
		
		addBehaviour(new EsperarPedidos(correlacaoLinear));
	}
	
	//Remove o registro do agente da página amarela quando sua execução é finalizada
	protected void takeDown(){
		try {
			DFService.deregister(this);
			System.out.println("Agente analisador+"+getAID().getName()+"está finalizado!");
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}	
	}
	
	/*Um método apenas para se registrar
	 * Nas páginas amarelas
	 * Assim, o consultor poderá procurar qualquer Metodos no DF
	 */
	private void registrarNoDF(){
		DFAgentDescription descricaoAgente = new DFAgentDescription();
		descricaoAgente.setName(this.getAID()); //Registra o nome do agente no DF
		
		//Criando um serviço
		ServiceDescription servicoMetodoNumerico = new ServiceDescription();
		servicoMetodoNumerico.setType("MetodoNumerico");
		servicoMetodoNumerico.setName("CorrelacoPearson");
		descricaoAgente.addServices(servicoMetodoNumerico);
		
		//Registrando o agente no DF
		try {
			DFService.register(this, descricaoAgente);
			System.out.println(this);
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}
}