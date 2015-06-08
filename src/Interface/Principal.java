package Interface;

import java.sql.SQLException;
import java.util.ArrayList;


import Dados.UsuarioDAO;
import Negocio.Usuario;




public class Principal {

	 public static void main(String[] args) throws SQLException, ClassNotFoundException{
		 
		 
	/*	 Usuario pessoa = new Usuario();
		 pessoa.setCPF("666.666.666-69");
		 pessoa.setEmail("senhor@inferno.com");
		 pessoa.setNome("Archanjo");
		 pessoa.setSobrenome("Lucifer");
		 Endereco localizacao = new Endereco();
		 localizacao.setID(2);
		 pessoa.setLocalizacao(localizacao);
		 Conta sistemaConta = new Conta();
		 sistemaConta.setLogin("Luci");
		 pessoa.setSistemaConta(sistemaConta);
		 
		 new UsuarioDAO().Inserir(pessoa);*/
		 
		 ArrayList<Usuario> pessoa = new UsuarioDAO().BuscarID(1);
		 Usuario a = pessoa.get(0);
		 System.out.println(a.getNome() + " " + a.getSobrenome());
		 System.out.println(a.getLocalizacao().getCidade() + " " + a.getLocalizacao().getBairro());
		 System.out.println(a.getSistemaConta().getLogin() + " " + a.getSistemaConta().getSenha());

		 
	 }
	
}
