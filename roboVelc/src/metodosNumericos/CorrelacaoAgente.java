package metodosNumericos;

import comportamentos.EsperarPedidos;
import comportamentos.RegistrarNoDF;

import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;

public class CorrelacaoAgente extends Agent{

	private static final long serialVersionUID = -7919542083794177881L;
	private double correlacaoLinear = 0.9;
	
	protected void setup(){
		System.out.println("Olá! Sou o analisador "+getLocalName()+" Quero registrar a correlacao!");
		addBehaviour(new RegistrarNoDF("MetodoNumerico", "CorrelacaoDePearson"));
		
		addBehaviour(new EsperarPedidos(correlacaoLinear));
	}
	
	//Remove o registro do agente da página amarela quando sua execução é finalizada
	protected void takeDown(){
		
		try {
			DFService.deregister(this);
			System.out.println("Agente analisador+"+getAID().getName()+"está finalizado!");
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}	
	}

}