package comportamentos;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class NotificarTendencia extends OneShotBehaviour{
	private static final long serialVersionUID = -4716337902447225254L;
	private AID verificadorDeTedencia;
	@Override
	public void action() {
		buscarAgenteTendencia();
		ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
		msg.addReceiver(verificadorDeTedencia);
		msg.setContent("oportunidade");
		myAgent.send(msg);
	}
	
	private void buscarAgenteTendencia() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		service.setType("VerificaTedencia");
		template.addServices(service);
		try {
			DFAgentDescription[] metodosAchados = DFService.search(myAgent, template);
			verificadorDeTedencia = new AID();
			verificadorDeTedencia = metodosAchados[0].getName();
			System.out.println("Foi achado o Agente verificador "+verificadorDeTedencia);
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}
}
