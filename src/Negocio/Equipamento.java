package Negocio;

public class Equipamento extends PadraoNegocio {

	private int ID;
	private String Disponivel;
	private int idEndereco;
	private String Proprietario_Cpf;
	private boolean usado;

	private Endereco localizacao;
	private Proprietario dono;
	
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

	public String isDisponivel() {

		if (usado == false) {
			return "disponivel";
		}

		return "indisponivel";
	}

	

	public String getDisponivel() {
		return Disponivel;
	}

	public void setDisponivel(String disponivel) {
		Disponivel = disponivel;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public Endereco getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Endereco localizacao) {
		this.localizacao = localizacao;
	}

	public Proprietario getDono() {
		return dono;
	}

	public void setDono(Proprietario dono) {
		this.dono = dono;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getProprietario_Cpf() {
		return Proprietario_Cpf;
	}

	public void setProprietario_Cpf(String proprietario_Cpf) {
		Proprietario_Cpf = proprietario_Cpf;
	}
	
}
