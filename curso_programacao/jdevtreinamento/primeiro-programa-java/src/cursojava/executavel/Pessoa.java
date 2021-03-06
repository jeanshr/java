package cursojava.executavel;

public abstract class Pessoa {

	/*Classe pai/master/superclasse possui os atributos comuns de todos os objetos filhos*/
	
	protected String nome;
	protected int idade;
	protected String dataNasciento;
	protected String registroGeral;
	protected String numeroCpf;
	protected String nomeMae;
	protected String nomePai;
	
	/*M�todo abstrato � obrigat�rio para as classes filhas*/
	public abstract double salario();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getDataNasciento() {
		return dataNasciento;
	}
	public void setDataNasciento(String dataNasciento) {
		this.dataNasciento = dataNasciento;
	}
	public String getRegistroGeral() {
		return registroGeral;
	}
	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}
	public String getNumeroCpf() {
		return numeroCpf;
	}
	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	/*Retorna true caso seja 18+*/
	public boolean pessoaMaiorIdade() {
		
		return idade >= 18;
	}
	
}
