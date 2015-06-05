package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Proprietario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
