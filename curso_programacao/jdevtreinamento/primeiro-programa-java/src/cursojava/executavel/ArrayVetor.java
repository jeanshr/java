package cursojava.executavel;

import javax.swing.JOptionPane;

public class ArrayVetor {

	public static void main(String[] args) {

		double[] notas = { 4.3, 3.4, 5.7, 7.1 };
		double[] notas2 = { 4.9, 3.9, 5.9, 7.9 };

		// aluno
		Aluno aluno = new Aluno();
		aluno.setNome("jean");
		aluno.setNomeEscola("jdev");

		// disciplina
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("java");
		disciplina.setNota(notas);

		// impressao
		aluno.getDisciplinas().add(disciplina);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("html");
		disciplina2.setNota(notas2);

		aluno.getDisciplinas().add(disciplina2);

		/*System.out.println("Nome do aluno = " + aluno.getNome() + " - curso: " + aluno.getNomeEscola());
		for (Disciplina d : aluno.getDisciplinas()) {
			System.out.println("Disciplina: " + d.getDisciplina());

			double notaMaxima = 0;
			for (int pos = 0; pos < d.getNota().length; pos++) {
				System.out.println(pos + " - " + d.getNota()[pos]);
				if (pos == 0) {
					notaMaxima = d.getNota()[pos];
				} else if (d.getNota()[pos] > notaMaxima) {
					notaMaxima = d.getNota()[pos];
				}
			}
			System.out.println("maior nota -  disciplina: " + d.getDisciplina() + " é: " + notaMaxima);
		}
		*/
		
		Aluno[] arrayAlunos = new Aluno[1];
		
		arrayAlunos[0] = aluno;
		
		for(int pos = 0; pos < arrayAlunos.length; pos++) {
			
			System.out.println("nome: " + arrayAlunos[pos].getNome());
			
			for(Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				System.out.println("disciplina: " + d.getDisciplina());
				
				for(int posnota = 0; posnota < d.getNota().length; posnota++) {
					System.out.println("Notas: " + d.getNota()[posnota]);
				}
			}
			
		}
	}
}
