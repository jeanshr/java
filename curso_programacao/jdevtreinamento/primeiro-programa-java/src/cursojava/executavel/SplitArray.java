package cursojava.executavel;

import java.util.Arrays;
import java.util.List;

public class SplitArray {
	
	public static void main(String[] args) {
		
		String texto = "jean, carlos, fraga, cunha";

		String[] valoresArray = texto.split(",");
		
		System.out.println(valoresArray[2]);
		
		//Convertendo array para lista
		List<String> list = Arrays.asList(valoresArray);
		System.out.println("----------Array to list---------------");
		for (String valorString : list) {
			System.out.println(valorString);
		}
		System.out.println("-----------List to array--------------");
		//Convertendo lista para array
		String[] conversaoArray = list.toArray(new String[4]);
		
		for(int pos = 0; pos < conversaoArray.length; pos++) {
			System.out.println(conversaoArray[pos]);
		}
	}

}
