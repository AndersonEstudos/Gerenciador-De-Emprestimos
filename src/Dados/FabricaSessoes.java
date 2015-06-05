package Dados;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class FabricaSessoes {
	 
	public Connection getConnection() {
	        try {
	            return DriverManager.getConnection(
	   	          "jdbc:mysql://localhost:3306/GerenciadorEmprestimos", "root" ,"root");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
