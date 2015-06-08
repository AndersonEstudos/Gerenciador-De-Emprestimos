package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Endereco;
import Negocio.Proprietario;


public class ProprietarioDAO extends PadraoDAO<Proprietario>
{

	public ProprietarioDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Proprietario objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Proprietario`" +
                "(`CPF`,`Dnome`,`Dsobrenome`,`Demail`,`Endereco_id`)+" +
                " values (?,?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objeto.getCPF());
        stmt.setString(2, objeto.getNome());
        stmt.setString(3, objeto.getSobrenome());
        stmt.setString(4, objeto.getEmail());
        stmt.setLong(5, objeto.getLocalizacao().getID());   
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}



	@Override
	public boolean Remover(Proprietario objeto) throws SQLException {
			// TODO Auto-generated method stub
			PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Proprietario`"
					+ "WHERE `Proprietario`.`CPF` = ?");
	        
			stmt.setString(1, objeto.getCPF());
	        stmt.execute();
	       
	        stmt.close();
			
			return true;
	}

	@Override
	public boolean Update(Proprietario objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE `GerenciadorEmprestimos`.`Proprietario`" +
	             "SET `CPF` = ?,`Dnome` = ?,`Dsobrenome` = ?,`Demail` = ?,`Endereco_id` = ?"
	             + "WHERE `idProprietario` = ?";
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
	  stmt.setString(1, objeto.getCPF());
	  stmt.setString(2, objeto.getNome());
	  stmt.setString(3, objeto.getSobrenome());
	  stmt.setString(4, objeto.getEmail());
	  stmt.setLong(5, objeto.getLocalizacao().getID());          
      stmt.setLong(6, objeto.getID());
      
      
      stmt.execute();
      stmt.close();
      
	return true;
	}

	@Override
	public ArrayList<Proprietario> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Proprietario WHERE idProprietario = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();

		ArrayList<Proprietario> lista = new ArrayList<Proprietario>();

		while (rs.next()) {
			
			
		   
	        ArrayList <Endereco> listaux = new EnderecoDAO().BuscarID(rs.getInt("Endereco_id"));
	       
		    // criando o objeto Contato
		    Proprietario objeto = new Proprietario();
		    
		    objeto.setID(rs.getInt("idProprietario"));
		    objeto.setCPF(rs.getString("CPF"));
	        objeto.setEmail(rs.getString("Demail"));
	        objeto.setNome(rs.getString("Dnome"));
	        objeto.setSobrenome(rs.getString("Dsobrenome"));
	        objeto.setLocalizacao(listaux.get(0));
	        
	        // adicionando o objeto à lista
		    lista.add(objeto);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	

}
