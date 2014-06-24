package investidores;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Comprar extends CyclicBehaviour {
	private static final long serialVersionUID = 8117839713833938344L;

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg !=null){
			System.out.println("O mercado está caindo/nHora de comprar");
		}
		else block();
	}

}
