package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Advertencia;

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
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Advertencia objeto) {
		// TODO Auto-generated method stub
		return false;
	}



}
