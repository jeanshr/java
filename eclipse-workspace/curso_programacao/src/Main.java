import java.util.Locale;
import java.util.Scanner;

/**
 * @author jean
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Olá Mundo!");
		System.out.println("Olá ola!");
		System.out.println("Olá ola!");
		int y = 32;
		System.out.println(y);
		double d = 10.9090;
		System.out.printf("%.3f%n", d);
		Locale.setDefault(Locale.US);
		System.out.printf("%.3f%n", d);
		String nome = "Jean";
		int idade = 27;
		double renda = 10000.0;
		System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);
		int a = 9;
		int b = 2;
		double resultado = (double) a / b;
		System.out.println(resultado);

		Scanner sc = new Scanner(System.in);
		System.out.println("digita aer jaum: ");
		String x;
		x = sc.next(); // ler
		System.out.println("Digitado: " + x);

		int p;
		p = sc.nextInt();
		System.out.println(p);

		sc.close();
	}

}
