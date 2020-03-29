import java.util.ArrayList;
import java.util.List;

/**
 * @author jean
 *
 */
public class Main {

	public static void main(String[] args) {

		/*Caneta c1 = new Caneta();
		c1.Cor = "Azul";
		c1.Ponta = 0.5f;
		c1.tampar();
		c1.rabiscar();
		c1.status();

		Caneta c2 = new Caneta();
		c2.Modelo = "Test";
		c2.Cor = "Preta";
		c2.destampar();
		c2.rabiscar();
		c2.status();
		String pathName = "/home/jecunha/workspace/github/java/eclipse-workspace/Files/ListaComplexa.txt";

		 */
			List<String> list = new ArrayList<>();

			list.add("jean"); //0
			list.add("veve");//1
			list.add("jojo");//2


			for(String x : list) {
				System.out.println(x);
			}

	}

}
