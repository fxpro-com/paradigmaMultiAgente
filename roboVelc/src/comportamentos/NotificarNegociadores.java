package comportamentos;

import java.io.IOException;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class NotificarNegociadores extends OneShotBehaviour{
	private static final long serialVersionUID = -6132530463809774826L;
	private AID negociador;
	private double tendencia;
	
	@Override
	public void action() {
		verificarTendencia();
		
		if(tendencia>0)
			buscarNegociadorDeVenda();
		else buscarNegociadorDeCompra();
			System.out.println("Vou notificar o negociador "+negociador);
			
		ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
		msg.addReceiver(negociador);
		msg.setContent("negociar");
		myAgent.send(msg);
	}
	
	private void verificarTendencia(){
		try {
			tendencia = Double.parseDouble(LeituraArquivo.leituraTendencia());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void buscarNegociadorDeVenda() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		service.setType("Vender");
		template.addServices(service);
		
		try {
			DFAgentDescription[] metodosAchados = DFService.search(myAgent, template);
			negociador = new AID();
			negociador = metodosAchados[0].getName();
			System.out.println(negociador);
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}
	
	private void buscarNegociadorDeCompra() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		service.setType("Comprar");
		template.addServices(service);
		
		try {
			DFAgentDescription[] metodosAchados = DFService.search(myAgent, template);
			negociador = new AID();
			negociador = metodosAchados[0].getName();
			System.out.println(negociador);
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}
}
