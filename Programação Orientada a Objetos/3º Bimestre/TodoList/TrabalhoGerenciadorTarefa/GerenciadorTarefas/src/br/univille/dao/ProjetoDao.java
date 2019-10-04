package br.univille.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.univille.model.Projeto;
import br.univille.model.Usuario;

public class ProjetoDao extends Dao {
	
	//Inserir um Projeto
	
	public void insert(Projeto projeto) {

		String sql = "INSERT INTO projeto(idProjeto, descProjeto, usuarioEmailUsuario) values(?,?,?)";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setInt(1, projeto.getIdProjeto());
			statement.setString(2, projeto.getDescProjeto());
			statement.setString(3, projeto.getUsuario().getEmailUsuario());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Excluir um projeto
	
	public void delete(Projeto projeto) {
		
		String sql = "DELETE FROM projeto WHERE idProjeto = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setInt(1, projeto.getIdProjeto());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Editar um projeto
	
	public void update(Projeto projeto) {
		String sql = "UPDATE projeto SET descProjeto = ? WHERE idProjeto = ?";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setString(1, projeto.getDescProjeto());
			statement.setInt(2, projeto.getIdProjeto());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Obter um projeto
	
	public Projeto getById(int idProjeto) {
		Projeto proj = null;
		
		String sql = "SELECT projeto.idProjeto, projeto.descProjeto, projeto.usuarioEmailUsuario, usuario.nomeUsuario"
				+ " FROM projeto"
				+ " INNER JOIN usuario ON usuario.usuarioEmailUsuario = projeto.usuarioEmailUsuario"
				+ " WHERE idProjeto = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setInt(1, idProjeto);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				proj = new Projeto();
				proj.setIdProjeto(resultSet.getInt(1));
				proj.setDescProjeto(resultSet.getString(2));
				
				Usuario usuario = new Usuario();
				usuario.setEmailUsuario(resultSet.getString(3));
				usuario.setNomeUsuario(resultSet.getString(4));
				
				proj.setUsuario(usuario);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return proj;
	}
	
	// Obter todos os projetos da tabela
	
	public List<Projeto> getAll(){
		List<Projeto> lista = new ArrayList<>();
		String sql = "SELECT projeto.descProjeto, projeto.usuarioEmailUsuario, usuario.nomeUsuario"
				+ " FROM projeto"
				+ " INNER JOIN usuario ON usuario.usuarioEmailUsuario = projeto.usuarioEmailUsuario";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Projeto projeto = new Projeto();
				projeto .setDescProjeto(resultSet.getString(1));
				
				Usuario usuario = new Usuario();
				usuario.setEmailUsuario(resultSet.getString(2));
				usuario.setNomeUsuario(resultSet.getString(3));
				
				projeto.setUsuario(usuario);
				
				lista.add(projeto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}


