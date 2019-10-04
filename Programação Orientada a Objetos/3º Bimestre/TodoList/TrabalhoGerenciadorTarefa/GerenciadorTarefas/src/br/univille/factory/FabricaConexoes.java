package br.univille.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	
	private static FabricaConexoes instance;

	private static String banco = "gerenciadortarefas";
	private static String usuario = "root";
	private static String senha = "univille";
	
	public static FabricaConexoes getInstance() {
		if(instance == null) {
			instance = new FabricaConexoes();
		}
		
		return instance;
	}
	
	public Connection getConnection(){
	
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + banco + "?serverTimezone=UTC",usuario,senha);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private FabricaConexoes() {}
	
}
