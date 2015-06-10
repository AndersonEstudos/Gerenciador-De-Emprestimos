package Negocio;

public class Bloqueio extends PadraoNegocio {
	private int ID;
	private String motivo;
	private String DataInicio;
	private String DataFim;
	private String Administrador_Cpf;
	private String Usuario_Cpf; 
	
	private Administrador administrador;
	private Usuario cliente;
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

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(String dataInicio) {
		DataInicio = dataInicio;
	}

	public String getDataFim() {
		return DataFim;
	}

	public void setDataFim(String dataFim) {
		DataFim = dataFim;
	}

	public String getAdministrador_Cpf() {
		return Administrador_Cpf;
	}

	public void setAdministrador_Cpf(String administrador_Cpf) {
		Administrador_Cpf = administrador_Cpf;
	}

	public String getUsuario_Cpf() {
		return Usuario_Cpf;
	}

	public void setUsuario_Cpf(String usuario_Cpf) {
		Usuario_Cpf = usuario_Cpf;
	}
	
}
