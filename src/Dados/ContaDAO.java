package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Conta;


public class ContaDAO extends PadraoDAO <Conta>{

	@Override
	public boolean Inserir(Conta objeto) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO `GerenciadorEmprestimos`.`Conta`" +
	                "(`Conta_Login`,`Conta_Senha`,`Numero_Advertencia`,`Numero_Bonificacao`)" +
	                " values (?,?,?,?)";
	        
	        PreparedStatement stmt = getConexao().prepareStatement(sql);

	        // preenche os valores
	        stmt.setString(1, objeto.getLogin());
	        stmt.setString(2, objeto.getSenha());
	        stmt.setLong(3, objeto.getAdvertencia());
	        stmt.setLong(4, objeto.getBonificacao());
	       

	        // executa
	        stmt.execute();
	        stmt.close();

	       

	        getConexao().close();
			
			return true;
	}

	

	@Override
	public boolean Remover(Conta objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Conta`"
				+ "WHERE `Conta`.`Conta_Login` = ?");
        
		stmt.setString(1, objeto.getLogin());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}



	@Override
	public boolean Update(Conta objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE `GerenciadorEmprestimos`.`Conta`" +
	             "SET `Conta_Login` = ?,`Conta_Senha` = ?,`Numero_Advertencia` = ?,`Numero_Bonificacao` = ?"
	             + "WHERE ``idConta` = ?";
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
		// preenche os valores
    stmt.setString(1, objeto.getLogin());
    stmt.setString(2, objeto.getSenha());
    stmt.setLong(3, objeto.getAdvertencia());
    stmt.setLong(4, objeto.getBonificacao());
	stmt.setLong(5, objeto.getID()); 
  
  stmt.execute();
  stmt.close();
  
  return true;
	}

	public ContaDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public ArrayList<Conta> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = getConexao().prepareStatement("select * from Conta where idConta = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Conta> lista = new ArrayList<Conta>();

		while (rs.next()) {
		
	        // criando o objeto admin
		    Conta objeto = new Conta();
		    
		    objeto.setID(rs.getInt("idConta"));
		    objeto.setLogin(rs.getString("Conta_Login"));
		    objeto.setSenha(rs.getString("Conta_Senha"));
		    objeto.setAdvertencia(rs.getInt("Numero_Advertencia"));
		    objeto.setBonificacao(rs.getInt("Numero_Bonificacao"));
		  
		

		    // adicionando o objeto à lista
		    lista.add(objeto);
		 
		}

		rs.close();
		stmt.close();

		return lista;
	}



	@Override
	public ArrayList<Conta> SelectALL() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Conta");
				
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Conta> lista = new ArrayList<Conta>();

		while (rs.next()) {
		
	        // criando o objeto admin
		    Conta objeto = new Conta();
		    
		    objeto.setID(rs.getInt("idConta"));
		    objeto.setLogin(rs.getString("Conta_Login"));
		    objeto.setSenha(rs.getString("Conta_Senha"));
		    objeto.setAdvertencia(rs.getInt("Numero_Advertencia"));
		    objeto.setBonificacao(rs.getInt("Numero_Bonificacao"));
		  
		

		    // adicionando o objeto à lista
		    lista.add(objeto);
		 
		}

		rs.close();
		stmt.close();

		return lista;
	}

	
}
