package Negocio;

public class Conta extends PadraoNegocio {

	private int ID;
	private String login;
	private String senha;
	private int bonificacao;
	private int advertencia;
	
	@Override	
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		ID = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(int bonificacao) {
		this.bonificacao = bonificacao;
	}

	public int getAdvertencia() {
		return advertencia;
	}

	public void setAdvertencia(int advertencia) {
		this.advertencia = advertencia;
	}
	
}
