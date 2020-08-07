package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_filha = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilathread) {
		pilha_filha.add(objetoFilathread);
	}

	@Override
	public void run() {

		System.out.println("rodandoooo");

		while (true) {

			Iterator iteracao = pilha_filha.iterator();
			synchronized (pilha_filha) {
				while (iteracao.hasNext()) {

					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
					System.out.println("------------------------------------");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());
					iteracao.remove();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
