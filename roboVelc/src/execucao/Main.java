package execucao;

import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


public class Main extends Agent {
	private static final long serialVersionUID = 3206847208968227199L;
	
	private AgentContainer metodos;
	
	protected void setup() {
		System.out.println("Iniciando a execução");
		addBehaviour(new CriandoContainers());
		addBehaviour(new CriandoAgentes());
	}
	
	public class CriandoContainers extends OneShotBehaviour{

		private static final long serialVersionUID = -7764417346591307311L;

		@Override
		public void action() {
			System.out.println("Criando Container");
			Runtime rt = Runtime.instance();
			ProfileImpl p = new ProfileImpl(true);
			metodos = rt.createAgentContainer(p);
		}
	}
	
	public class CriandoAgentes extends OneShotBehaviour{

		private static final long serialVersionUID = -7774814918503262919L;

		@Override
		public void action() {
			try {
				AgentController correlacao = metodos.createNewAgent("correlacao", "metodosNumericos.CorrelacaoAgente", null);
				correlacao.start();
				
				AgentController tendencia = metodos.createNewAgent("tendencia", "investidores.Tendencia", null);
				tendencia.start();
				
				AgentController vendendor = metodos.createNewAgent("vendendor", "investidores.Vendendor", null);
				vendendor.start();
				
				AgentController comprador = metodos.createNewAgent("comprador", "investidores.Comprador", null);
				comprador.start();
				
				AgentController consultor =metodos.createNewAgent("consultor", "metodosNumericos.ConsultorAgente", null);
				consultor.start();
				
			} catch (StaleProxyException e) {
				e.printStackTrace();
			}
		}		
	}
}

