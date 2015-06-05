package Interface;

import java.sql.SQLException;

import Dados.EnderecoDAO;
import Negocio.Endereco;


public class Principal {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 
		 Endereco local = new Endereco();
		 EnderecoDAO localbd = new EnderecoDAO();
		 
		 local.setCidade("Natal");
		 local.setBairro("candelaria");
		 local.setRua("rua das alamedas");
		 local.setNumero(23);
		 localbd.Inserir(local);
		 
	 }
	
}
