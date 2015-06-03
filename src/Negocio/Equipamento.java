package Negocio;

public class Equipamento extends PadraoNegocio{

	private int ID;
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
	
}
