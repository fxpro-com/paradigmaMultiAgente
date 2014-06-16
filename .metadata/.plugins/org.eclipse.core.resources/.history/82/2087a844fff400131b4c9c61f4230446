package metodosNumericos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class LeituraArquivo {
	
	static String correlacaoJava, correlacaoHaskell;
	
	public LeituraArquivo(){
		
	}
	
	public static String leituraArquivoHaskell() throws IOException{
		
		Scanner scanner = new Scanner(new FileReader("saidaEmHaskell.txt"))
        .useDelimiter("\\||\\n");
		while (scanner.hasNext()) {
			correlacaoHaskell = scanner.next();
		}
		return correlacaoHaskell;
	}
	
	public static String leituraArquivoJava() throws IOException{
		
		Scanner scanner = new Scanner(new FileReader("saidaEmJava.txt"))
        .useDelimiter("\\||\\n");
		while (scanner.hasNext()) {
			correlacaoJava = scanner.next();
		}
		return correlacaoJava;
	}
	
	
}

	
