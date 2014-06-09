package robo;

import java.awt.datatransfer.DataFlavor;

import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class CompradorDeLivros extends Agent{
	
	private double correlacaoLinear = 0.9;
	
	protected void setup(){
		System.out.println("Olá! Sou o analisador"+getLocalName()+"Quero registrar a correlacao!");
		DFAgentDescription descricaoAgente = new DFAgentDescription();
		descricaoAgente.setName(this.getAID()); //Registra o nome do agente no DF
		
		ServiceDescription servicoMetodoNumerico = new ServiceDescription();
		servicoMetodoNumerico.setType("Metodo numerico");
		servicoMetodoNumerico.setName("Correlacao Linear");
		
		descricaoAgente.addServices(servicoMetodoNumerico);
		
		try {
			DFService.register(this, descricaoAgente);
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
		
	}
	
	protected void takeDown(){
		System.out.println("Agente analisador+"+getAID().getName()+"está finalizado!");
		
	}
}