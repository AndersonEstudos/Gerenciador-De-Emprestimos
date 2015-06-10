package Negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dados.ContaDAO;
import Dados.EnderecoDAO;
import Dados.EquipamentoDAO;
import Dados.FacadeDados;
import Dados.ProprietarioDAO;
import Dados.UsuarioDAO;

public class FacadeNegocio {
	
	private FacadeDados FachadaDados;
	
	 public FacadeNegocio() throws ClassNotFoundException{
		FachadaDados = new FacadeDados();
	}
	
	public void CadastrarUsuario(Usuario objeto) throws SQLException, ClassNotFoundException {
		
		new ContaDAO().Inserir(objeto.getSistemaConta());
		Integer idEndereco = FachadaDados.buscaEndereco(objeto.getLocalizacao());
		if ( idEndereco == null)
		{
			new EnderecoDAO().Inserir(objeto.getLocalizacao());
			objeto.getLocalizacao().setID(FachadaDados.buscaEndereco(objeto.getLocalizacao()));
		}
		else
		{
			objeto.getLocalizacao().setID(idEndereco);
		}
			
		
		new UsuarioDAO().Inserir(objeto);
	
	
	}

	public void CadastrasEquipamento(Equipamento objeto) throws SQLException, ClassNotFoundException {
		new EquipamentoDAO().Inserir(objeto);
	}

	public void SolicitarEmprestimo() {

	}

	public void CancelarEmprestimo() {
	}

	public void BloqueiarUser() {

	}
	public void AutenticarLogin(Conta objeto){
		FachadaDados.AutenticarLogin(objeto);
	}
}
