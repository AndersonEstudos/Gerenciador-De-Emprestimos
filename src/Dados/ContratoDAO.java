package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Negocio.Contrato;
import Negocio.Equipamento;
import Negocio.Proprietario;
import Negocio.Usuario;

public class ContratoDAO extends PadraoDAO <Contrato>{

	@Override
	public boolean Inserir(Contrato objeto) throws SQLException {
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Contrato`" +
                "(`idEquipamento`,`Proprietario_Cpf`,`Usuario_Cpf`,`Data_Inicio`,`Data_Fim`,`Exigencia`,`Preco`)" +
                " values (?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setLong(1, objeto.getBike().getID());
        stmt.setString(2, objeto.getDono().getCPF());
        stmt.setString(3, objeto.getCliente().getCPF());
        stmt.setString(4, objeto.getDataInicio());
        stmt.setString(5, objeto.getDataFim());
        stmt.setString(6, objeto.getExigencia());
        stmt.setString(7, objeto.getPreco());
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
		
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean Remover(Contrato objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Contrato`"
				+ "WHERE `Contrato`.`IDcontrato` = ?");
        
		stmt.setLong(1, objeto.getID());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}



	@Override
	public boolean Update(Contrato objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE `GerenciadorEmprestimos`.`Contrato`" +
	             "SET `idEquipamento` = ?,`Proprietario_Cpf` = ?,`Usuario_Cpf` = ?,`Data_Inicio` = ?,`Data_Fim` = ?,`Exigencia` = ?,`Preco` = ?"
	             + "WHERE `IDcontrato` = ?";
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
	stmt.setLong(1, objeto.getBike().getID());
    stmt.setString(2, objeto.getDono().getCPF());
    stmt.setString(3, objeto.getCliente().getCPF());
    stmt.setString(4, objeto.getDataInicio());
    stmt.setString(5, objeto.getDataFim());
    stmt.setString(6, objeto.getExigencia());
    stmt.setString(7, objeto.getPreco()); 
	stmt.setLong(8, objeto.getID()); 
   
   stmt.execute();
   stmt.close();
   
   return true;
	}

	public ContratoDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public ArrayList<Contrato> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = getConexao().prepareStatement("select * from Contrato where IDContrato = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Contrato> lista = new ArrayList<Contrato>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Contrato where CPF = ?");
			stmt2.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
	        aux.next();
		   
	        PreparedStatement stmt3 = getConexao().prepareStatement("select idProprietario from Contrato,Proprietario where CPF = ?");
	        stmt3.setString(1,rs.getString("Proprietario_Cpf"));
	        ResultSet aux2 = stmt3.executeQuery();
	        aux2.next();
		   
	        ArrayList <Usuario> listusaux = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
	        ArrayList <Proprietario> listusaux2 = new ProprietarioDAO().BuscarID(aux2.getInt("idProprietario"));
	        ArrayList <Equipamento> listaux3 = new EquipamentoDAO().BuscarID(rs.getInt("idEquipamento"));
	        
	        // criando o objeto admin
		    Contrato objeto = new Contrato();
		    
		    objeto.setBike(listaux3.get(0));
		    objeto.setCliente(listusaux.get(0));
		    objeto.setDono(listusaux2.get(0));
		    objeto.setID(rs.getInt("IDcontrato"));
		    objeto.setDataFim(rs.getString("Data_Fim"));
		    objeto.setDataInicio(rs.getString("Conta_Inicio"));
		    objeto.setExigencia(rs.getString("Exigencia"));
		    objeto.setPreco(rs.getString("Preco"));
		  
		

		    // adicionando o objeto à lista
		    lista.add(objeto);
		    aux.close();
		    aux2.close();
		    stmt2.close();
		    stmt3.close();
		}

		rs.close();
		stmt.close();

		return lista;
	}

	

}
