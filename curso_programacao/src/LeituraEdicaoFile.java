import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class LeituraEdicaoFile {

	public static void main(String[] args) {
		// misturando os exercicios, ler um arquivo e adicionar dados

		Scanner input = new Scanner(System.in);
		String[] lines = new String[1];

		String path = "/home/jean/Documentos/Teste.txt";

		try(BufferedReader buf = new BufferedReader(new FileReader(path))){
			String Line = buf.readLine();

			if(Line == null) { // valida se arquivo = vazio
				System.out.println("No content available");

			}
			else {
				while(Line != null) {
					System.out.println(Line);
					Line = buf.readLine(); // pula para proxima linha
				}
			}
			System.out.println("Would u like to add more content?: 1/2");
			int choice = input.nextInt();

			if(choice == 1) {
				try {
					for(int i = 0; i < lines.length; i++) {

						System.out.println("ADD: ");
						lines[i] = input.next();
						String line = lines[i];
						BufferedWriter Writer = new BufferedWriter(new FileWriter(path, true));
						Writer.write("Added " + line);
						Writer.newLine();
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}

			}
			else {
				System.out.println(":pernalonga-no:");
			}

			input.close();
		}
		catch(IOException e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}

}
