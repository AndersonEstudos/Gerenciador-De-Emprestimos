package Dados;

import java.sql.Connection;
import Negocio.PadraoNegocio;


public abstract class PadraoDAO {
	
	private Connection conexao;
	
	public PadraoDAO() throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conexao = new FabricaSessoes().getConnection();
	}
	
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public abstract boolean Inserir();
	public abstract boolean Remover();
	public abstract boolean Update();

	
}

