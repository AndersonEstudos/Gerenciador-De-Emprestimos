package Dados;

import java.sql.Connection;
import java.sql.SQLException;

import Negocio.PadraoNegocio;


public abstract class PadraoDAO<T extends PadraoNegocio> {
	
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

	public abstract boolean Inserir(T objeto) throws SQLException;
	public abstract boolean Remover();
	public abstract boolean Update(T objeto);

	
}

