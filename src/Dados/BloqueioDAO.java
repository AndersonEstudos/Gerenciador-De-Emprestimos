package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Administrador;
import Negocio.Bloqueio;
import Negocio.Usuario;

public class BloqueioDAO extends PadraoDAO<Bloqueio> {

	public BloqueioDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Bloqueio objeto) throws SQLException {
		// TODO Auto-generated method stub
		// cria um preparedStatement
        String sql = "INSERT INTO `GerenciadorEmprestimos`.`Bloqueio`" +
                "(`Administrador_Usuario_Cpf`,`Usuario_Cpf`,`Motivo`,`Data_Inicio`,`Data_Fim`)" +
                " values (?,?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objeto.getAdministrador().getPessoa().getCPF());
        stmt.setString(2, objeto.getCliente().getCPF());
        stmt.setString(3, objeto.getMotivo());
        stmt.setString(4, objeto.getDataInicio());
        stmt.setString(5, objeto.getDataFim());
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}



	@Override
	public boolean Remover(Bloqueio objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Bloqueio`"
				+ "WHERE  `Bloqueio`.`IDbloqueio` = ?");
        
		stmt.setLong(1, objeto.getID());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}

	@Override
	public boolean Update(Bloqueio objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		 String sql = "UPDATE `GerenciadorEmprestimos`.`Bloqueio`" +
	                "SET `Administrador_Usuario_Cpf` = ?,`Usuario_Cpf` = ?,`Motivo` = ?,`Data_Inicio` = ?,`Data_Fim` = ?" +
	                "WHERE `IDbloqueio` = ?";
	        
	        PreparedStatement stmt = getConexao().prepareStatement(sql);

	        // preenche os valores
	        stmt.setString(1, objeto.getAdministrador().getPessoa().getCPF());
	        stmt.setString(2, objeto.getCliente().getCPF());
	        stmt.setString(3, objeto.getMotivo());
	        stmt.setString(4, objeto.getDataInicio());
	        stmt.setString(5, objeto.getDataFim());
	        stmt.setLong(6, objeto.getID());
	       

	        // executa
	        stmt.execute();
	        stmt.close();

	       

	        getConexao().close();
	        return true;
	}

	@Override
	public ArrayList<Bloqueio> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Bloqueio where IDbloqueio = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Bloqueio> lista = new ArrayList<Bloqueio>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Bloqueio where CPF = ?");
			stmt.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
	        aux.next(); 
		   
	        PreparedStatement stmt3 = getConexao().prepareStatement("select idAdministrador from Bloqueio,Administrador where Usuario_Cpf = ?");
	        stmt3.setString(1,rs.getString("Administrador_Usuario_Cpf"));
	        ResultSet aux2 = stmt3.executeQuery();
	        aux2.next();
		   
	        ArrayList <Usuario> listusaux = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
	        ArrayList <Administrador> listusaux2 = new AdministradorDAO().BuscarID(aux2.getInt("idAdministrador"));
	     	        
	        // criando o objeto admin
		    Bloqueio objeto = new Bloqueio();
		    
	
		    objeto.setCliente(listusaux.get(0));
		    objeto.setAdministrador(listusaux2.get(0));
		    objeto.setID(rs.getInt("IDbloqueio"));
		    objeto.setMotivo(rs.getString("Motivo"));
		    objeto.setDataFim(rs.getString("Data_Fim"));
		    objeto.setDataInicio(rs.getString("Data_Inicio"));
		    objeto.setAdministrador_Cpf(rs.getString("Administrador_Usuario_Cpf"));
		    objeto.setUsuario_Cpf("Usuario_Cpf");
		  
		

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

	@Override
	public ArrayList<Bloqueio> SelectALL() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Bloqueio");
		
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Bloqueio> lista = new ArrayList<Bloqueio>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Bloqueio where CPF = ?");
			stmt.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
	        aux.next(); 
		   
	        PreparedStatement stmt3 = getConexao().prepareStatement("select idAdministrador from Bloqueio,Administrador where Usuario_Cpf = ?");
	        stmt3.setString(1,rs.getString("Administrador_Usuario_Cpf"));
	        ResultSet aux2 = stmt3.executeQuery();
	        aux2.next();
		   
	        ArrayList <Usuario> listusaux = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
	        ArrayList <Administrador> listusaux2 = new AdministradorDAO().BuscarID(aux2.getInt("idAdministrador"));
	     	        
	        // criando o objeto admin
		    Bloqueio objeto = new Bloqueio();
		    
	
		    objeto.setCliente(listusaux.get(0));
		    objeto.setAdministrador(listusaux2.get(0));
		    objeto.setID(rs.getInt("IDbloqueio"));
		    objeto.setMotivo(rs.getString("Motivo"));
		    objeto.setDataFim(rs.getString("Data_Fim"));
		    objeto.setDataInicio(rs.getString("Data_Inicio"));
		    objeto.setAdministrador_Cpf(rs.getString("Administrador_Usuario_Cpf"));
		    objeto.setUsuario_Cpf("Usuario_Cpf");
		  
		

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
