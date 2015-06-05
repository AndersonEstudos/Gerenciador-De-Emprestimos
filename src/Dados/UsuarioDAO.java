package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
