package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		Thread threadNF = new Thread(thread2);
		threadNF.start();

		// codigo do sistema do suario continua o fluxo de trabalho
		System.out.println("Fim threads");
		// fluxo do sistema, cadastro de vendas, emissao de notas fiscal, etc..
		JOptionPane.showMessageDialog(null, "Continua executando pro usuario");

	}
//threads
	private static Runnable thread1 = new Runnable() {

		public void run() {
			// executa o que precisamos
			/* codigoo da rotina que eu quero executar em paralelo */
			for (int pos = 0; pos < 10; pos++) {

				System.out.println("Testes em background - emails " + pos);
				try {
					Thread.sleep(1000); // Executar com tempo de parada
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} // Fim codigo paralelo

		}
	};

	private static Runnable thread2 = new Runnable() {

		public void run() {
			// executa o que precisamos
			/* codigoo da rotina que eu quero executar em paralelo */
			for (int pos = 0; pos < 10; pos++) {

				System.out.println("Testes em background - EFSS  " + pos);
				try {
					Thread.sleep(1000); // Executar com tempo de parada
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} // Fim codigo paralelo
		}
	};

}
