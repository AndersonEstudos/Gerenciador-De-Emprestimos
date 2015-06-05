package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Solicitacao;

public class SolicitacaoDAO extends PadraoDAO<Solicitacao>{

	public SolicitacaoDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Solicitacao objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Solicitacao`" +
                "(`idEquipamento`,`Usuario_Cpf`,`Prioridade`,`Status`, `Data_solicitacao`)" +
                " values(?,?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setLong(1, objeto.getBike().getID());
        stmt.setString(2, objeto.getCliente().getCPF());
        stmt.setString(3, objeto.getPrioridade());
        stmt.setString(4, objeto.getStatus());
        stmt.setString(5, objeto.getData_solicitacao());
       
       

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
	public boolean Update(Solicitacao objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
