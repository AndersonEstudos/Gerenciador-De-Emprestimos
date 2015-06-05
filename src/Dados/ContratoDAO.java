package Dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Contrato;

public class ContratoDAO extends PadraoDAO <Contrato>{

	@Override
	public boolean Inserir(Contrato objeto) throws SQLException {
		String sql = "INSERT INTO `GerenciadorEmprestimos`.`Contrato`" +
                "(`idEquipamento`,`Proprietario_Cpf`,`Usuario_Cpf`,`Data_Inicio`,`Data_Fim`,`Exigencia`,`Preco`)" +
                " values (?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = getConexao().prepareStatement(sql);

        // preenche os valores
        stmt.setLong(1, objeto.getBike().getID());
        stmt.setString(2, objeto.getDono().getCPF());
        stmt.setString(3, objeto.getCliente().getCPF());
        stmt.setString(4, objeto.getDataInicio());
        stmt.setString(5, objeto.getDataFim());
        stmt.setString(6, objeto.getExigencia());
        stmt.setString(7, objeto.getPreco());
       

        // executa
        stmt.execute();
        stmt.close();

       

        getConexao().close();
		
		return true;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Contrato objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	public ContratoDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
