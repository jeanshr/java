package cursojava.interfaces;

/*Esta interface ser� o contrato de autentica��o*/
public interface PermitirAcesso {
	
	public boolean autenticar(String login, String senha);
	public boolean autenticar();
}