package investidores;

import comportamentos.RegistrarNoDF;
import comportamentos.Vender;

import jade.core.Agent;

public class Vendendor extends Agent {
	private static final long serialVersionUID = 5566772927053431524L;
	
	protected void setup() {
		addBehaviour(new RegistrarNoDF("Vender", "Vendendor"));
		addBehaviour(new Vender());
	}

}
