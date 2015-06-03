package Negocio;

public class Contrato extends PadraoNegocio {
	
	private int ID;
	private Equipamento bike;
	private Proprietario dono;
	private Usuario cliente;
	private String DataInicio;
	private String DataFim;
	private String exigencia;
	private String preco;
	
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

	public Equipamento getBike() {
		return bike;
	}

	public void setBike(Equipamento bike) {
		this.bike = bike;
	}

	public Proprietario getDono() {
		return dono;
	}

	public void setDono(Proprietario dono) {
		this.dono = dono;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
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

	public String getExigencia() {
		return exigencia;
	}

	public void setExigencia(String exigencia) {
		this.exigencia = exigencia;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}
