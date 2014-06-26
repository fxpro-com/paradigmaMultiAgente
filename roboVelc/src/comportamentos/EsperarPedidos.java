package comportamentos;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EsperarPedidos extends CyclicBehaviour {
	private static final long serialVersionUID = 7192572878341493779L;
	
	private ACLMessage resposta;
	private double correlacaoLinear;

	public EsperarPedidos(double correlacaoLinear) {
		this.correlacaoLinear=correlacaoLinear;
	}

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg !=null){
			resposta= msg.createReply();
			System.out.println("O agente "+msg.getSender().getName() + "está se comunicando");
			String conteudo = msg.getContent();
			
			if(conteudo.equalsIgnoreCase("Pedido de informação")){
				
				resposta.setContent(String.valueOf(correlacaoLinear));
				myAgent.send(resposta);
			}
		}
		else block();
	}

}
