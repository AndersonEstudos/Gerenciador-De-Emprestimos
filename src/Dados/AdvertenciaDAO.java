package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Administrador;
import Negocio.Advertencia;
import Negocio.Usuario;

public class AdvertenciaDAO extends PadraoDAO<Advertencia>{

	public AdvertenciaDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Advertencia objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		// cria um preparedStatement
        String sql = "INSERT INTO `GerenciadorEmprestimos`.`Advertencia`" +
                "(`Administrador_Usuario_Cpf`,`Usuario_Cpf`,`Advertencia`)" +
                " values (?,?,?)";
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objeto.getAdministrador().getPessoa().getCPF());
        stmt.setString(2, objeto.getCliente().getCPF());
        stmt.setString(3, objeto.getAdvertencia());
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}

	@Override
	public boolean Remover(Advertencia objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Advertencia`"
				+ "WHERE `Advertencia`.`IDadvertencia` = ?;");
        
		stmt.setLong(1, objeto.getID());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}

	@Override
	public boolean Update(Advertencia objeto) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "UPDATE `GerenciadorEmprestimos`.`Advertencia`" +
	                "SET `Administrador_Usuario_Cpf` = ?,`Usuario_Cpf` = ?,`Advertencia` = ?" +
	                "WHERE `IDadvertencia` = ?";
	        
	        PreparedStatement stmt = getConexao().prepareStatement(sql);

	        // preenche os valores
	        stmt.setString(1, objeto.getAdministrador().getPessoa().getCPF());
	        stmt.setString(2, objeto.getCliente().getCPF());
	        stmt.setString(3, objeto.getAdvertencia());
	        stmt.setLong(4, objeto.getID());
	       

	        // executa
	        stmt.execute();
	        stmt.close();

	       

	        getConexao().close();
	        return true;
	}

	@Override
	public ArrayList<Advertencia> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Advertencia where IDadvertencia = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Advertencia> lista = new ArrayList<Advertencia>();

		while (rs.next()) {
			
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Advertencia where CPF = ?");
			stmt2.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
			aux.next();
	        
			PreparedStatement stmt3 = getConexao().prepareStatement("select idAdministrador from Advertencia,Administrador where Usuario_Cpf = ?");
			stmt3.setString(1,rs.getString("Administrador_Usuario_Cpf"));
	        ResultSet aux2 = stmt3.executeQuery();
	        aux2.next();
		   
	        ArrayList <Usuario> listusaux = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
	        ArrayList <Administrador> listusaux2 = new AdministradorDAO().BuscarID(aux2.getInt("idAdministrador"));
	     	        
	        // criando o objeto admin
		    Advertencia objeto = new Advertencia();
		    
	
		    objeto.setCliente(listusaux.get(0));
		    objeto.setAdministrador(listusaux2.get(0));
		    objeto.setID(rs.getInt("IDadvertencia"));
		    objeto.setAdvertencia(rs.getString("Advertencia"));
		   
		  
		

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
