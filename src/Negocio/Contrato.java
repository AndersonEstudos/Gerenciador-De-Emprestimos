package Negocio;

public class Contrato extends PadraoNegocio {
	
	private int ID;
	private String DataInicio;
	private String DataFim;
	private String exigencia;
	private String preco;
	private String Proprietario_Cpf;
	private String Usuario_Cpf;
	private int idEquipamento;
	
	private Equipamento bike;
	private Proprietario dono;
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

	public String getUsuario_Cpf() {
		return Usuario_Cpf;
	}

	public void setUsuario_Cpf(String usuario_Cpf) {
		Usuario_Cpf = usuario_Cpf;
	}

	public int getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getProprietario_Cpf() {
		return Proprietario_Cpf;
	}

	public void setProprietario_Cpf(String proprietario_Cpf) {
		Proprietario_Cpf = proprietario_Cpf;
	}
	
}
