package comportamentos;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class LeituraArquivo{
	static String correlacao;
	
	public static String leituraArquivo() throws IOException{
		
		Scanner scanner = new Scanner(new FileReader("../calculoPearsonEmC.txt"))
        .useDelimiter("\\||\\n");
		while (scanner.hasNext()) {
			correlacao = scanner.next();
		}
		return correlacao;
	}	
}

	
