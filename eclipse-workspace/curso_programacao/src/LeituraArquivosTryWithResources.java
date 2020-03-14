import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivosTryWithResources {

	public static void main(String[] args) {
		// modo limpo
		String path = "/home/jean/Documentos/Livros.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))){

			String line = br.readLine();
			
			if(line == null) { // valida se arquivo = vazio
				System.out.println("No content available");
			}
			else {
				while(line != null) {
					System.out.println(line);
					line = br.readLine(); // pula para proxima linha
				}
			}
		}
		catch(IOException e) {
			System.out.println("ERROR " + e.getMessage());
		}

	}

}
