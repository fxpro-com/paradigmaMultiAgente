package comportamentos;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class ProcurarCotacoes extends OneShotBehaviour {
	private static final long serialVersionUID = -8819431658328564461L;
	
	private AID[] correlacoes;
	
	@Override
	public void action() {
		procurarCorrelacoes();
		mandarMensagens();
	}
	
	private void procurarCorrelacoes(){
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		service.setType("MetodoNumerico");
		template.addServices(service);
		try {
			DFAgentDescription[] metodosAchados = DFService.search(myAgent, template);
			correlacoes = new AID[metodosAchados.length];
			for(int i=0; i<metodosAchados.length;i++){
				correlacoes[i] = metodosAchados[i].getName();
			}
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}
	
	private void mandarMensagens(){
		ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
		
		for(int i=0; i < correlacoes.length; i++){
			System.out.println("Foi achado o Agente: "+correlacoes[i]);
			msg.addReceiver(correlacoes[i]);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			msg.setContent("Pedido de informação");
			myAgent.send(msg);
		}
	}

}
