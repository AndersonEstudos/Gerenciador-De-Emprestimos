package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Negocio.Equipamento;
import Negocio.Solicitacao;
import Negocio.Usuario;

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
	public boolean Remover(Solicitacao objeto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM `GerenciadorEmprestimos`.`Solicitacao`"
				+ "WHERE `Solicitacao`.`IDsolicitacao` = ?");
        
		stmt.setLong(1, objeto.getID());
        stmt.execute();
       
        stmt.close();
		
		return true;
	}

	@Override
	public boolean Update(Solicitacao objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE `GerenciadorEmprestimos`.`Solicitacao`" +
	             "`idEquipamento` = ?,`Usuario_Cpf` = ?,`Prioridade` = ?,`Status` = ?,`Data_solicitacao` = ?"
	             + "WHERE `IDsolicitacao` = ?" ;
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		
       stmt.setLong(1, objeto.getBike().getID());
       stmt.setString(2, objeto.getCliente().getCPF());
       stmt.setString(3, objeto.getPrioridade());
       stmt.setString(4, objeto.getStatus());
       stmt.setString(5, objeto.getData_solicitacao());
       stmt.setLong(6, objeto.getID());
       
       
       stmt.execute();
       stmt.close();
		return true;
	}

	@Override
	public ArrayList<Solicitacao> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = getConexao().prepareStatement("select * from Solicitacao where IDsolicitacao = ?");
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		
		ArrayList<Solicitacao> lista = new ArrayList<Solicitacao>();

		while (rs.next()) {
		
			PreparedStatement stmt2 = getConexao().prepareStatement("select idUsuario from Usuario,Solicitacao where CPF = ?");
			stmt2.setString(1,rs.getString("Usuario_Cpf"));
			ResultSet aux = stmt2.executeQuery();
			aux.next();
		   
	        ArrayList <Usuario> listusaux = new UsuarioDAO().BuscarID(aux.getInt("idUsuario"));
	        ArrayList <Equipamento> listusaux2 = new EquipamentoDAO().BuscarID(rs.getInt("idEquipamento	"));
	     	        
	        // criando o objeto admin
		    Solicitacao objeto = new Solicitacao();
		    
	
		    objeto.setCliente(listusaux.get(0));
		    objeto.setBike(listusaux2.get(0));
		    objeto.setID(rs.getInt("IDadvertencia"));
		    objeto.setStatus(rs.getString("Status"));
		    objeto.setData_solicitacao(rs.getString("Data_solicitacao"));
		    objeto.setPrioridade(rs.getString("Prioridade"));
		   
		  
		

		    // adicionando o objeto à lista
		    lista.add(objeto);
		    aux.close();
		    stmt2.close();
		}

		rs.close();
		stmt.close();

		return lista;
	}

	
}
