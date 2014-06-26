#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define QUANTIDADE_CANDLES 100
#define TAMANHO_STRING 50

double leituraCotacoes[QUANTIDADE_CANDLES];
char nomeRobo[50],nomeTipoGrafico[2];

double metodoCorrelacao(int tempoCorrelacao);
void detectaRoboETipoDeGrafico();

int main(){
	FILE *arquivo;
	double tempoCorrelacao = 21;
	char pontoProlog = '.';

	arquivo = fopen("calculoPearsonEmC.txt","wt");

	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);
	tempoCorrelacao = 34;
	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);
	tempoCorrelacao = 55;
	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);
	tempoCorrelacao = 89;
	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);

	fclose(arquivo);


	arquivo = fopen("/home/cleiton/github/paradigmaMultiAgente/calculoPearsonEmC.txt","wt");

	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);
	tempoCorrelacao = 34;
	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);
	tempoCorrelacao = 55;
	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);
	tempoCorrelacao = 89;
	fprintf(arquivo, "%lf%c\n",metodoCorrelacao(tempoCorrelacao), pontoProlog);

	fclose(arquivo);

	return 0;	
}

double metodoCorrelacao(int tempoCorrelacao){

	FILE *arquivo;
        double somaOrdenadas = 0, somaAbcissas = 0,
	       somaOrdenadasQuadrado = 0, somaAbcissasQuadrado = 0,
	       somaXvezesY = 0, correlacao,
	       numeroAbcissa, numeroOrdenada,
	       numerador, denominador_1,denominador;

	detectaRoboETipoDeGrafico();

	if( (strcmp(nomeTipoGrafico,"M1")) == 0)
		arquivo = fopen("tabela1Minuto.csv","rt"); 
	else if( (strcmp(nomeTipoGrafico,"M5")) == 0)
		arquivo = fopen("tabela5Minutos.csv","rt");
	else if( (strcmp(nomeTipoGrafico,"H1")) == 0)
		arquivo = fopen("tabela1Hora.csv","rt");
	else
		printf("Erro, tabela nao encontrada\n");

	for(int c=0; c<QUANTIDADE_CANDLES; c++){
	    fscanf(arquivo, "%lf",&leituraCotacoes[c]);
	}

	for(int c=0; c<tempoCorrelacao; c++){
	    numeroAbcissa = leituraCotacoes[c];
	    numeroOrdenada = leituraCotacoes[c+1];

	    somaAbcissas =   somaAbcissas + numeroAbcissa;
	    somaAbcissasQuadrado += (numeroAbcissa*numeroAbcissa);
	    somaOrdenadas = somaOrdenadas + numeroOrdenada;
	    somaOrdenadasQuadrado += (numeroOrdenada*numeroOrdenada);
	    somaXvezesY = somaXvezesY + (numeroOrdenada*numeroAbcissa);
	 } 

	numerador =((tempoCorrelacao*somaXvezesY)-((somaAbcissas)*(somaOrdenadas)));
	denominador_1 =((tempoCorrelacao*somaAbcissasQuadrado)-(somaAbcissas*somaAbcissas))*
	((tempoCorrelacao*somaOrdenadasQuadrado)-(somaOrdenadas*somaOrdenadas));	

	denominador = pow(denominador_1, 1.0/2.0); 

	correlacao = numerador/denominador; 
	
	return correlacao;

	printf("%f\n",correlacao);
	fclose(arquivo);
}

void detectaRoboETipoDeGrafico(){
	FILE *arquivo;

	arquivo = fopen("criterioEntrada.txt","rt");
	fgets(nomeRobo, 50,arquivo);
	fgets(nomeTipoGrafico, 3,arquivo);
	fclose(arquivo);
}
