package metodosNumericos;

import comportamentos.ProcurarCotacoes;
import comportamentos.ReceberCotacoes;
import jade.core.Agent;

public class ConsultorAgente extends Agent{
	private static final long serialVersionUID = -1528819378039323293L;

	protected void setup(){
		System.out.println("Olá! Sou o Consultor "+getLocalName()+" Quero procurar as correlacoes!");
		addBehaviour(new ProcurarCotacoes());
		addBehaviour(new ReceberCotacoes());
	}
}
