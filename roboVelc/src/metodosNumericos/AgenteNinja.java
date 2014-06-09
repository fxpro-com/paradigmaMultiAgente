package metodosNumericos;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgenteNinja extends Agent{
	
	private AID[] correlacoes;
	
	protected void setup(){
		
		addBehaviour(new TickerBehaviour(this, 6000) {

			@Override
			protected void onTick() {
				DFAgentDescription template = new DFAgentDescription();
				ServiceDescription service = new ServiceDescription();
				
				service.setType("Metodo numerico");
				template.addServices(service);
				
				try {
					DFAgentDescription[] resultado = DFService.search(myAgent, template);
					correlacoes = new AID[resultado.length];
					for(int i=0; i < resultado.length; i++){
						correlacoes[i] = resultado[i].getName();
						System.out.println(correlacoes[i]);
					}
					
				} catch (FIPAException erro) {
					erro.printStackTrace();
				}
				
				myAgent.addBehaviour(new Comportamento());
			}
		});
	}
}