package comportamentos;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class NotificarNegociadores extends OneShotBehaviour{
	private static final long serialVersionUID = -6132530463809774826L;
	private AID negociador;
	private double cotacao;
	
	public NotificarNegociadores(double cotacao) {
		this.cotacao = cotacao;
	}

	@Override
	public void action() {
		buscarNegociador();
		
		ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
		msg.addReceiver(negociador);
		msg.setContent("negociar");
		myAgent.send(msg);
	}
	
	private void buscarNegociador() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		service.setType("Vender");
		template.addServices(service);
		try {
			DFAgentDescription[] metodosAchados = DFService.search(myAgent, template);
			negociador = new AID();
			negociador = metodosAchados[0].getName();
			System.out.println(negociador);
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}

}
