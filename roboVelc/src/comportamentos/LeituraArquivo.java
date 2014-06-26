package comportamentos;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class LeituraArquivo{
	static String correlacao;
	static String tendencia;
	
	public static String leituraCorrelacao() throws IOException{
		
		Scanner scanner = new Scanner(new FileReader("../calculoPearsonEmC.txt"))
        .useDelimiter("\\||\\n");
		while (scanner.hasNext()) {
			correlacao = scanner.next();
		}
		return correlacao;
	}
	
	public static String leituraTendencia() throws IOException{
		
		Scanner scanner = new Scanner(new FileReader("../tendencia.txt"))
        .useDelimiter("\\||\\n");
		while (scanner.hasNext()) {
			tendencia = scanner.next();
		}
		return tendencia;
	}	
}

	
