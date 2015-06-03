package Negocio;

public class Usuario extends PadraoNegocio{
	
	private int ID;
	private String CPF;
	private String nome;
	private String sobrenome;
	private String email;
	private Endereco localizacao;
	private Conta sistemaConta;
	
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Endereco localizacao) {
		this.localizacao = localizacao;
	}

	public Conta getSistemaConta() {
		return sistemaConta;
	}

	public void setSistemaConta(Conta sistemaConta) {
		this.sistemaConta = sistemaConta;
	}
	
	
	
}
