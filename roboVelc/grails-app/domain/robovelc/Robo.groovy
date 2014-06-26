package robovelc

class Robo {

	String nomeRobo
	String tipoGrafico

    static constraints = {
    	nomeRobo(maxSize: 30)
    	tipoGrafico(blank:false, inList:["M1", "M5", "H1"] )
    }
}

