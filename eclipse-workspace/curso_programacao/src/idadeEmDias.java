import java.util.Scanner;

public class idadeEmDias {

	public static void main(String[] args) {
		
		int Entrada = 0, Ano, Mes, Dias;
		
		Scanner sc = new Scanner(System.in);
		Entrada = sc.nextInt();
				
		Ano = Entrada / 365;
		Mes = Entrada % 365 / 30;
		Dias = Entrada % 365 % 30;

		System.out.println(Ano + " ano(s)");
		System.out.println(Mes + " mes(es)");
		System.out.println(Dias + " dia(s)");
		
		sc.close();
	}

}
