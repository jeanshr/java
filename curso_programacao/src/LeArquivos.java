import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeArquivos {

	public static void main(String[] args) {

        File file = new File("/home/jecunha/workspace/github/java/eclipse-workspace/Files/Test.txt");
        Scanner scan = null;

        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (scan != null) {
                scan.close();
			}	
	}
	}
}