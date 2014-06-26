package comportamentos;

import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class RegistrarNoDF extends OneShotBehaviour{
	private static final long serialVersionUID = -5125123631192783579L;
	
	private String tipo;
	private String nome;

	public RegistrarNoDF(String tipo, String nome) {
		this.tipo = tipo;
		this.nome = nome;
	}

	@Override
	public void action() {
			DFAgentDescription descricaoAgente = new DFAgentDescription();
			descricaoAgente.setName(myAgent.getAID()); //Registra o nome do agente no DF
			
			//Criando um serviço
			ServiceDescription servicoMetodoNumerico = new ServiceDescription();
			servicoMetodoNumerico.setType(tipo);
			servicoMetodoNumerico.setName(nome);
			descricaoAgente.addServices(servicoMetodoNumerico);
			
			//Registrando o agente no DF
			try {
				DFService.register(myAgent, descricaoAgente);
				System.out.println("Registrado o Agente "+myAgent+" no DF");
			} catch (FIPAException erro) {
				erro.printStackTrace();
			}
		
	}

}
