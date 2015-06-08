package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Negocio.Endereco;

public class EnderecoDAO extends PadraoDAO<Endereco> {

	public EnderecoDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Endereco objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Endereco`" +
                "(`Rua`,`Cidade`,`Bairro`,`Numero_`)" +
                " values (?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objeto.getRua());
        stmt.setString(2, objeto.getCidade());
        stmt.setString(3, objeto.getBairro());
        stmt.setLong(4, objeto.getNumero());
        
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}


	@Override
	public boolean Remover(Endereco objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Endereco`"
				+ "WHERE `Endereco`.`idEndereco` = ?");
        
		stmt.setLong(1, objeto.getID());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}

	@Override
	public boolean Update(Endereco objeto) throws SQLException {
		// TODO Auto-generated method stub 
		String sql = "UPDATE `GerenciadorEmprestimos`.`Endereco`" +
	             "SET `Rua` = ?,`Cidade` = ?,`Bairro` = ?,`Numero_` = ?"
	             + "WHERE `idEndereco` = ?";
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
	stmt.setString(1, objeto.getRua());
	stmt.setString(2, objeto.getCidade());
	stmt.setString(3, objeto.getBairro());
	stmt.setLong(4, objeto.getNumero()); 
	stmt.setLong(5, objeto.getID()); 
    
    stmt.execute();
    stmt.close();
    
	return true;
	}

	@Override
	public ArrayList<Endereco> BuscarID(int id) throws SQLException {
		PreparedStatement stmt = getConexao().prepareStatement("select * from Endereco WHERE idEndereco = ?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		ArrayList<Endereco> lista = new ArrayList<Endereco>();

		while (rs.next()) {

		    // criando o objeto Contato
		    Endereco local = new Endereco();
		    local.setID(rs.getInt("idEndereco"));
		    local.setRua(rs.getString("Rua"));
	        local.setCidade(rs.getString("Cidade"));
	        local.setBairro(rs.getString("Bairro"));
	        local.setNumero(rs.getInt("Numero_"));
	        
	        // adicionando o objeto à lista
		    lista.add(local);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	

}
