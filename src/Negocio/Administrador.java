package Negocio;

public class Administrador extends PadraoNegocio {

	private int ID;
	private Usuario pessoa;
	private String DadaInicio;
	private String DataFim;

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

	public Usuario getPessoa() {
		return pessoa;
	}

	public void setPessoa(Usuario pessoa) {
		this.pessoa = pessoa;
	}

	public String getDadaInicio() {
		return DadaInicio;
	}

	public void setDadaInicio(String dadaInicio) {
		DadaInicio = dadaInicio;
	}

	public String getDataFim() {
		return DataFim;
	}

	public void setDataFim(String dataFim) {
		DataFim = dataFim;
	}
	
}
