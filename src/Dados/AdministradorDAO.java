package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Administrador;


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
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Administrador objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
