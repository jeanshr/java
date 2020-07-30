package cursojava.executavel;

public class TestandoClassesFilhas {

	public static void main(String[] args) {
		
		Aluno a = new Aluno();
		
		a.setNome("jean");
		a.setNomeEscola("N/A");
		a.setIdade(16);
		
		Diretor d = new Diretor();
		
		d.setNome("rafa");
		d.setRegistroGeral("987asd32");
		d.setIdade(50);
		
		Secretario s = new Secretario();
		
		s.setNumeroCpf("989779878");
		s.setExperiencia("Administração");
		s.setIdade(18);

		System.out.println(a);
		System.out.println(d);
		System.out.println(s);
		
		System.out.println("sal: " + a.salario());
		System.out.println("sal: " + d.salario());
		System.out.println("sal: " + s.salario());
		
		teste(a);
		teste(d);
		teste(s);
	}
	
	public static void teste(Pessoa pessoa) {
		System.out.println("pessoa legal: " + pessoa.getNome() + " salario: " + pessoa.salario());
	}
}
