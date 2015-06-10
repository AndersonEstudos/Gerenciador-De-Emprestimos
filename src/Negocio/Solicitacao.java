package Negocio;

public class Solicitacao extends PadraoNegocio{
	
	private int ID;
	private String prioridade;
	private String Status;
	private String Data_solicitacao;
	private int idEquipamento;
	private String Usuario_Cpf;
	
	private Equipamento bike;
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

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getData_solicitacao() {
		return Data_solicitacao;
	}

	public void setData_solicitacao(String data_solicitacao) {
		Data_solicitacao = data_solicitacao;
	}

	public int getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getUsuario_Cpf() {
		return Usuario_Cpf;
	}

	public void setUsuario_Cpf(String usuario_Cpf) {
		Usuario_Cpf = usuario_Cpf;
	}
	
	
}
