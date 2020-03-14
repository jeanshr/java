import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;;

public class FileWriterExercise {

	public static void main(String[] args) {
		//FileWriter and BufferedWriter
		String[] lines = new String[] {"Hello World", "Test", "Zikaum"};
		String path = "/home/jean/Documentos/outputTest.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {//adiciona mais linhas ao inves de substit
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}