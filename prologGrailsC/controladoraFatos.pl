:-include('tabelaFatos.pl').

manipulaFatosPearson:- open('calculoPearsonEmC.txt',read,Arquivo), 
	read(Arquivo,Correlacao21Candles),
	read(Arquivo,Correlacao34Candles),
	read(Arquivo,Correlacao55Candles),
	read(Arquivo,Correlacao89Candles),
	close(Arquivo),
	open('saidaMql.txt',read,Arquivo2),
	read(Arquivo2,StatusCorrelacao21),
	read(Arquivo2,StatusCorrelacao34),
	read(Arquivo2,StatusCorrelacao55),
	read(Arquivo2,StatusCorrelacao89),
	close(Arquivo2),
	insereNovoFato(Correlacao21Candles, Correlacao34Candles, Correlacao55Candles, Correlacao89Candles,
		       StatusCorrelacao21, StatusCorrelacao34, StatusCorrelacao55, StatusCorrelacao89),
	excluiFato(StatusCorrelacao21, StatusCorrelacao34, StatusCorrelacao55, StatusCorrelacao89).
manipulaFatosPearson.


insereNovoFato(Correlacao21Candles, Correlacao34Candles, Correlacao55Candles, Correlacao89Candles,
	       StatusCorrelacao21, StatusCorrelacao34, StatusCorrelacao55, StatusCorrelacao89):- 
	StatusCorrelacao21 = 1,tell('tabelaFatos.pl'), Correlacao21Candles > 0.8,
	assert(pearson(21,Correlacao21Candles)), 
	listing(pearson(X,Y)), told,

	StatusCorrelacao34 = 1, tell('tabelaFatos.pl'),Correlacao34Candles > 0.8,
	assert(pearson(34,Correlacao34Candles)),
	listing(pearson(X,Y)), told,

	StatusCorrelacao55 = 1, tell('tabelaFatos.pl'), Correlacao55Candles > 0.8,
	assert(pearson(55,Correlacao55Candles)),
	listing(pearson(X,Y)), told,

	StatusCorrelacao89 = 1, tell('tabelaFatos.pl'),Correlacao89Candles > 0.8,
	assert(pearson(89,Correlacao89Candles)),
	listing(pearson(X,Y)), told.

insereNovoFato(Correlacao21Candles, Correlacao34Candles, Correlacao55Candles, Correlacao89Candles,
	       StatusCorrelacao21, StatusCorrelacao34, StatusCorrelacao55, StatusCorrelacao89).
	
excluiFato(StatusCorrelacao21, StatusCorrelacao34, StatusCorrelacao55, StatusCorrelacao89):-
	StatusCorrelacao21 = -1,tell('tabelaFatos.pl'), 
	retract(pearson(21,Correlacao21Candles)), 
	listing(pearson(X,Y)), told,

	StatusCorrelacao34 = -1, tell('tabelaFatos.pl'),Correlacao34Candles > 0.8,
	assert(pearson(34,Correlacao34Candles)),
	listing(pearson(X,Y)), told,

	StatusCorrelacao55 = -1, tell('tabelaFatos.pl'), Correlacao55Candles > 0.8,
	retract(pearson(55,Correlacao55Candles)),
	listing(pearson(X,Y)), told,

	StatusCorrelacao89 = -1, tell('tabelaFatos.pl'),Correlacao89Candles > 0.8,
	retract(pearson(89,Correlacao89Candles)),
	listing(pearson(X,Y)), told.

excluiFato(StatusCorrelacao21, StatusCorrelacao34, StatusCorrelacao55, StatusCorrelacao89).

