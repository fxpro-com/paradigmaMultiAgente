package investidores;

import comportamentos.Comprar;
import comportamentos.RegistrarNoDF;
import jade.core.Agent;

public class Comprador extends Agent {
	private static final long serialVersionUID = 5566772927053431524L;
	
	protected void setup() {
		addBehaviour(new RegistrarNoDF("Comprar", "Comprador"));
		addBehaviour(new Comprar());
	}
}
