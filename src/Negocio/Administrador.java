package Negocio;

public class Administrador extends PadraoNegocio {

	private int ID;
	private String DadaInicio;
	private String DataFim;
	private String Usuario_Cpf;
	
	private Usuario pessoa;
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
	public String getUsuario_Cpf() {
		return Usuario_Cpf;
	}

	public void setUsuario_Cpf(String usuario_Cpf) {
		Usuario_Cpf = usuario_Cpf;
	}
}
