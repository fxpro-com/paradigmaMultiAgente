package investidores;

import comportamentos.EsperarOportunidades;
import comportamentos.RegistrarNoDF;

import jade.core.Agent;

public class Tendencia extends Agent {
	private static final long serialVersionUID = 1340463054278418604L;

	protected void setup() {	
		addBehaviour(new RegistrarNoDF("VerificaTedencia", "Tendencia"));
		addBehaviour(new EsperarOportunidades());
	}

}
