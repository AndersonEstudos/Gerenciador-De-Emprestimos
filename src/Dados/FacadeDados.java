package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Negocio.Conta;
import Negocio.Endereco;
import Negocio.Usuario;

public class FacadeDados {
	private Connection conexao;

	public FacadeDados() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub

		Class.forName("com.mysql.jdbc.Driver");
		conexao = new FabricaSessoes().getConnection();

	}
	
	public boolean AutenticarLogin(Conta objeto)
	{
		
		return false;
		
	}
	
	public Integer buscaEndereco(Endereco objeto) throws SQLException{
		
		PreparedStatement stmt = new FabricaSessoes().getConnection().prepareStatement("SELECT idEndereco,COUNT(idEndereco) from Endereco where RUA = ? and Cidade = ? and Bairro = ? and Numero_ = ?");
		stmt.setString(1, objeto.getRua());
		stmt.setString(2, objeto.getCidade());
		stmt.setString(3, objeto.getBairro());
		stmt.setInt(4, objeto.getNumero());
		ResultSet rs = stmt.executeQuery();
		rs.next();
		
		int count = rs.getInt("COUNT(idEndereco)");
		int idEndereco = rs.getInt("idEndereco");
		
		stmt.close();
		rs.close();
		
		if( count == 0)
		{
			return null;
		}
		else
		{
			return idEndereco; 
		}
		
	}
}
