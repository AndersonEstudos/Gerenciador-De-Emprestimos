 package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Telefone;

public class TelefoneDAO extends PadraoDAO<Telefone>{

	public TelefoneDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Inserir(Telefone objeto) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean Remover(Telefone objeto) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Telefone objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Telefone> BuscarID(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
