package comportamentos;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceberCotacoes extends CyclicBehaviour {
	private static final long serialVersionUID = 5586882767740583579L;

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg !=null){
			String content = msg.getContent();
			System.out.println("Resposta do Agente "+msg.getSender().getName()+": "+content);
		}
		else
			block();
	}

}
