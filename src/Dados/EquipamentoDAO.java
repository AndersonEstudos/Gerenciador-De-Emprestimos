package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Equipamento;

public class EquipamentoDAO extends PadraoDAO<Equipamento>{

	public EquipamentoDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Equipamento objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Equipamento`" +
                "(`Endereco_idEndereco`,`Proprietario_Cpf`)" +
                " values (?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setLong(1, objeto.getLocalizacao().getID());
        stmt.setString(2, objeto.getDono().getCPF());
        
       

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
	public boolean Update(Equipamento objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
