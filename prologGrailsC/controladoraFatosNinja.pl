:-include('controladoraFatos.pl').
:-include('tabelaFatos.pl').
:-include('tabelaNinja.pl').

somaGeral21(21,Correlacao):- CorrelacaoParcial21 is (Correlacao + CorrelacaoParcial21)/2.

somaGeral34(34,Correlacao):- CorrelacaoParcial34 is (Correlacao + CorrelacaoParcial34)/2.

somaGeral21(55,Correlacao):- CorrelacaoParcial55 is (Correlacao + CorrelacaoParcial55)/2.

somaGeral21(89,Correlacao):- CorrelacaoParcial89 is (Correlacao + CorrelacaoParcial89)/2.

guardaFatosNinja(CorrelacaoParcial21, CorrelacaoParcial34, CorrelacaoParcial55, CorrelacaoParcial89):- 
	tell('tabelaFatosNinja.pl'),
	assert(pearson(21,Correlacao21Candles)), 
	listing(pearson(X,Y)), told,

	tell('tabelaFatosNinja.pl'),
	assert(pearson(34,Correlacao34Candles)),
	listing(pearson(X,Y)), told,

	tell('tabelaFatosNinja.pl'),
	assert(pearson(55,Correlacao55Candles)),
	listing(pearson(X,Y)), told,

	tell('tabelaFatosNinja.pl'),
	assert(pearson(89,Correlacao89Candles)),
	listing(pearson(X,Y)), told.



