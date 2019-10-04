package br.univille.dao;

import java.sql.Connection;

import br.univille.factory.FabricaConexoes;

public abstract class Dao {
	 	
	 public Connection getConnection() {
	 	return FabricaConexoes.getInstance().getConnection();
	 }

}
