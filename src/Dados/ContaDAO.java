package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Conta objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	public ContaDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
