package metodosNumericos;

import jade.core.behaviours.Behaviour;

public class Comportamento extends Behaviour {

	@Override
	public void action() {
		System.out.println("Correlacao ativa!");

	}

	@Override
	public boolean done() {
		return true;
	}

}
