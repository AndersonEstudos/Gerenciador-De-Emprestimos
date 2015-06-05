package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        ;
       

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
	public boolean Update(Endereco objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
