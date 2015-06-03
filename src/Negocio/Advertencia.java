package Negocio;

public class Advertencia extends PadraoNegocio {
	
	private int ID;
	private Administrador administrador;
	private Usuario cliente;
	private String advertencia;
	
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

	public String getAdvertencia() {
		return advertencia;
	}

	public void setAdvertencia(String advertencia) {
		this.advertencia = advertencia;
	}
	
}
