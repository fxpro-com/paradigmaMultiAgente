package comportamentos;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EsperarPedidos extends CyclicBehaviour {

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		
		if(msg !=null){
			System.out.println("O agente "+msg.getSender().getName() + "pediu a cotação");
		}
		else block();
	}

}
