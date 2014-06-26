carregaCorrelacoes:-open('calculoPearsonEmC.txt',read,Arquivo),
	read(Arquivo,Linha1),
	read(Arquivo,Linha2),
	read(Arquivo,Linha3),
	read(Arquivo,Linha4),
	alavancagem(Linha1,Linha2,Linha3,Linha4),
	close(Arquivo).

alavancagem(Linha1,Linha2,Linha3,Linha4):-  
	( (Linha1 > 0.8, Cont = 0.1) , (Linha2 > 0.8, Cont = 0.2) , (Linha3 > 0.8, 
	Cont = 0.3 ) , (Linha4 > 0.8, Cont = 0.4) ), registraOperacao(Cont).
alavancagem(Linha1,Linha2,Linha3,Linha4).

registraOperacao(Cont):- 
	Cont > 0, tell('entradaMQL.txt'),
	write(Cont), write ('compre'), nl,told.


