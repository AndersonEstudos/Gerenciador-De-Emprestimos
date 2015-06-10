package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Conta;
import Negocio.Endereco;
import Negocio.Usuario;

public class UsuarioDAO extends PadraoDAO <Usuario>{

	public UsuarioDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Usuario objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		// cria um preparedStatement
        String sql = "INSERT INTO `GerenciadorEmprestimos`.`Usuario`" +
                "(`CPF`,`Login`,`Unome`,`idlocalizacao`,`Usobrenome`,`Uemail`)" +
                " values (?,?,?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objeto.getCPF());
        stmt.setString(2, objeto.getSistemaConta().getLogin());
        stmt.setString(3, objeto.getNome());
        stmt.setLong(4, objeto.getLocalizacao().getID());
        stmt.setString(5, objeto.getSobrenome());
        stmt.setString(6, objeto.getEmail());
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
	}

	
	@Override
	public boolean Remover(Usuario objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Usuario`"
				+ "WHERE `Usuario`.`CPF` = ?");
        
		stmt.setString(1, objeto.getCPF());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}

	@Override
	public boolean Update(Usuario objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE `GerenciadorEmprestimos`.`Usuario`" +
	             "SET `CPF` = ?,`Login` = ?,`Unome` = ?, `idlocalizacao` = ?,`Usobrenome` = ?,`Uemail` = ?"
	             + "WHERE `idUsuario` = ?" ;
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
        stmt.setString(1, objeto.getCPF());
        stmt.setString(2, objeto.getSistemaConta().getLogin());
        stmt.setString(3, objeto.getNome());
        stmt.setLong(4, objeto.getLocalizacao().getID());
        stmt.setString(5, objeto.getSobrenome());
        stmt.setString(6, objeto.getEmail());
        stmt.setLong(7, objeto.getID());
        
        
        stmt.execute();
        stmt.close();
		return true;
	}

	@Override
	public ArrayList<Usuario> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = getConexao().prepareStatement("select * from Usuario where idUsuario = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idConta from Usuario,Conta where Conta_Login = ?");
			stmt2.setString(1,rs.getString("Login"));
			ResultSet aux = stmt2.executeQuery();
	        aux.next();
		   
	        ArrayList <Endereco> listaux = new EnderecoDAO().BuscarID(rs.getInt("idLocalizacao"));
	        ArrayList <Conta> listaux2 = new ContaDAO().BuscarID(aux.getInt("idConta"));
			
	        // criando o objeto admin
		    Usuario objeto = new Usuario();
		    
		    objeto.setLocalizacao(listaux.get(0)); 
		    objeto.setSistemaConta(listaux2.get(0));
		    objeto.setID(rs.getInt("idUsuario"));
		    objeto.setCPF(rs.getString("CPF"));
		    objeto.setEmail(rs.getString("Uemail"));
		    objeto.setNome(rs.getString("Unome"));
		    objeto.setSobrenome(rs.getString("Usobrenome"));
		    objeto.setLogin(rs.getString("Login"));
		    objeto.setIdlocalizacao(rs.getInt("idlocalizacao"));
		  
		

		    // adicionando o objeto à lista
		    lista.add(objeto);
		    aux.close();
		    stmt2.close();
		}

		rs.close();
		stmt.close();
		

		return lista;
	}

	@Override
	public ArrayList<Usuario> SelectALL() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Usuario");
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idConta from Usuario,Conta where Conta_Login = ?");
			stmt2.setString(1,rs.getString("Login"));
			ResultSet aux = stmt2.executeQuery();
	        aux.next();
		   
	        ArrayList <Endereco> listaux = new EnderecoDAO().BuscarID(rs.getInt("idLocalizacao"));
	        ArrayList <Conta> listaux2 = new ContaDAO().BuscarID(aux.getInt("idConta"));
			
	        // criando o objeto admin
		    Usuario objeto = new Usuario();
		    
		    objeto.setLocalizacao(listaux.get(0)); 
		    objeto.setSistemaConta(listaux2.get(0));
		    objeto.setID(rs.getInt("idUsuario"));
		    objeto.setCPF(rs.getString("CPF"));
		    objeto.setEmail(rs.getString("Uemail"));
		    objeto.setNome(rs.getString("Unome"));
		    objeto.setSobrenome(rs.getString("Usobrenome"));
		    objeto.setLogin(rs.getString("Login"));
		    objeto.setIdlocalizacao(rs.getInt("idlocalizacao"));
		

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
