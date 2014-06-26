:-dynamic metodos/3.
:-include('bancoDeDados.pl').
:-include('tabelaFatos.pl').
:-include('controladoraFatos.pl').
:-include('controleOperacao.pl').

main:- 
	carregaBase,
	insereNovoFatoPearson,
       	carregaCorrelacoes,halt.







