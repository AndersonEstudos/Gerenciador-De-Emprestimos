package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Negocio.Endereco;
import Negocio.Equipamento;
import Negocio.Proprietario;


public class EquipamentoDAO extends PadraoDAO<Equipamento>{

	public EquipamentoDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Equipamento objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Equipamento`" +
                "(`Endereco_idEndereco`,`Proprietario_Cpf`)" +
                " values (?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setLong(1, objeto.getLocalizacao().getID());
        stmt.setString(2, objeto.getDono().getCPF());
        
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}

	@Override
	public boolean Remover(Equipamento objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Equipamento`"
				+"`Equipamento`.`idEquipamento` = ?");
        
		stmt.setLong(1, objeto.getID());
        stmt.execute();
        
       
        stmt.close();
		
		return true;
	}

	@Override
	public boolean Update(Equipamento objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE `GerenciadorEmprestimos`.`Equipamento`" +
	             "SET `Endereco_idEndereco` = ?,`Proprietario_Cpf` = ?"
	             + "WHERE `idEquipamento` = ?";
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
	 stmt.setLong(1, objeto.getLocalizacao().getID());
     stmt.setString(2, objeto.getDono().getCPF());          
     stmt.setLong(3, objeto.getID());
     
     
     stmt.execute();
     stmt.close();
     
	return true;
	}

	@Override
	public ArrayList<Equipamento> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Equipamento where idEquipamento = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Equipamento> lista = new ArrayList<Equipamento>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idProprietario from Equipamento,Proprietario where CPF = ?");
			stmt2.setString(1,rs.getString("Proprietario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
	        aux.next();
	        
	   	   
	        ArrayList <Endereco> listaux = new EnderecoDAO().BuscarID(rs.getInt("Endereco_idEndereco"));
			ArrayList<Proprietario> listaux2 = new ProprietarioDAO().BuscarID(aux.getInt("idProprietario"));
	        // criando o objeto admin
		    Equipamento objeto = new Equipamento();
		   
		    
		    objeto.setLocalizacao(listaux.get(0)); 
		    objeto.setID(rs.getInt("idEquipamento"));
		    objeto.setDono(listaux2.get(0));
		
		  
		

		    // adicionando o objeto à lista
		    lista.add(objeto);
		    aux.close();
		    stmt2.close();
		}

		rs.close();
		stmt.close();

		return lista;
	}

	

}
