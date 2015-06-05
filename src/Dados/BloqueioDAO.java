package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Bloqueio;

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
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Bloqueio objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
