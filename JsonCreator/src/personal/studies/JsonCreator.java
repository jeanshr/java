package personal.studies;

import java.awt.List;
import java.awt.image.ReplicateScaleFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonCreator {

	public void readFile() throws FileNotFoundException {
		File file = new File("C:\\Users\\jecunha\\Desktop\\Testes\\test.txt");
		Scanner scan = new Scanner(file);

		String searchStr = "value";
		while (scan.hasNext()) {
			String line = scan.nextLine().toLowerCase().toString();
			if (line.contains(searchStr)) {
				line.replaceAll(" ","");
				System.out.println(line);

			}
		}
	}
}
