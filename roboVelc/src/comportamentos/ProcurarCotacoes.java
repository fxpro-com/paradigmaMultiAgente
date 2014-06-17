package comportamentos;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class ProcurarCotacoes extends OneShotBehaviour {
	private static final long serialVersionUID = -8819431658328564461L;
	
	private AID[] correlacoes;
	
	@Override
	public void action() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
		
		service.setType("MetodoNumerico");
		template.addServices(service);
		
		try {
			DFAgentDescription[] resultado = DFService.search(myAgent, template);
			correlacoes = new AID[resultado.length];
			
			for(int i=0; i < resultado.length; i++){
				correlacoes[i] = resultado[i].getName();
				System.out.println("Foi achado o Agente: "+correlacoes[i]);
				msg.addReceiver(correlacoes[i]);
				Thread.sleep(3000);
				msg.setContent(correlacoes[i].getName()+" passe a correlação");
				myAgent.send(msg);			
			}
			
		} catch (FIPAException erro) {
			erro.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
