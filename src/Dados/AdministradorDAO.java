package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Administrador;
import Negocio.PadraoNegocio;

public class AdministradorDAO extends PadraoDAO {

	public AdministradorDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean Inserir(PadraoNegocio objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		Administrador objetoBD = (Administrador) objeto;
		
		// cria um preparedStatement
        String sql = "INSERT INTO `GerenciadorEmprestimos`.`Administrador`" +
                "(`Usuario_Cpf`,`Data_Inicio`,`Data_Fim`)" +
                " values (?,?,?)";
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, objetoBD.getPessoa().getCPF());
        stmt.setString(2, objetoBD.getDadaInicio());
        stmt.setString(3, objetoBD.getDataFim());
       

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
	public boolean Update(PadraoNegocio objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
