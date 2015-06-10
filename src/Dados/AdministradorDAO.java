package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Administrador;
import Negocio.Usuario;


public class AdministradorDAO extends PadraoDAO <Administrador>{

	public AdministradorDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean Inserir(Administrador objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		// cria um preparedStatement
        String sql = "INSERT INTO `GerenciadorEmprestimos`.`Administrador`" +
                "(`Usuario_Cpf`,`Data_Inicio`,`Data_Fim`)" +
                " values (?,?,?)";
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objeto.getPessoa().getCPF());
        stmt.setString(2, objeto.getDadaInicio());
        stmt.setString(3, objeto.getDataFim());
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}

	@Override
	public boolean Remover(Administrador objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Administrador` " 
				+ "WHERE Usuario_Cpf = ?;");
        
		stmt.setString(1, objeto.getPessoa().getCPF());
        stmt.execute();
       
        stmt.close();
   
		return true;
	}

	@Override
	public boolean Update(Administrador objeto) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "UPDATE `GerenciadorEmprestimos`.`Administrador`" +
	                "SET `idAdministrador` = ?,`Data_Inicio` = ?,`Data_Fim` = ?" +
                "WHERE `Usuario_Cpf` = ?";
	        
	        PreparedStatement stmt = getConexao().prepareStatement(sql);

	        // preenche os valores
	        stmt.setString(1, objeto.getPessoa().getCPF());
	        stmt.setString(2, objeto.getDadaInicio());
	        stmt.setString(3, objeto.getDataFim());
	        stmt.setLong(4, objeto.getID());
	       

	        // executa
	        stmt.execute();
	        stmt.close();

	       

	        getConexao().close();
	        return true;
	}

	@Override
	public ArrayList<Administrador> BuscarID(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Administrador where idAdministrador = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Administrador> lista = new ArrayList<Administrador>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Administrador where CPF = ?");
			stmt2.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
			aux.next();
	        
		   
	        ArrayList <Usuario> listusario = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
			// criando o objeto admin
		    Administrador admin = new Administrador();
		   
		    
		    admin.setPessoa(listusario.get(0)); 
		    admin.setID(rs.getInt("idAdministrador"));
		    admin.setDadaInicio(rs.getString("Data_Inicio"));
		    admin.setDataFim(rs.getString("Data_Fim"));
		    admin.setUsuario_Cpf(rs.getString("Usuario_Cpf"));
		  
		

		    // adicionando o objeto à lista
		    lista.add(admin);
		    aux.close();
		    stmt2.close();
		}

		rs.close();
		stmt.close();

		return lista;
	}

	@Override
	public ArrayList<Administrador> SelectALL() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Administrador");
		
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Administrador> lista = new ArrayList<Administrador>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Administrador where CPF = ?");
			stmt2.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
			aux.next();
	        
		   
	        ArrayList <Usuario> listusario = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
			// criando o objeto admin
		    Administrador admin = new Administrador();
		   
		    
		    admin.setPessoa(listusario.get(0)); 
		    admin.setID(rs.getInt("idAdministrador"));
		    admin.setDadaInicio(rs.getString("Data_Inicio"));
		    admin.setDataFim(rs.getString("Data_Fim"));
		    admin.setUsuario_Cpf(rs.getString("Usuario_Cpf"));
		  
		

		    // adicionando o objeto à lista
		    lista.add(admin);
		    aux.close();
		    stmt2.close();
		}

		rs.close();
		stmt.close();

		return lista;
	}

	

}
