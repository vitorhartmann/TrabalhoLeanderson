package br.univille.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.univille.model.Usuario;

public class UsuarioDao extends Dao {
	
	//Inserir um usuário
	
	public void insert(Usuario usuario) {

		String sql = "INSERT INTO usuario(emailUsuario, nomeUsuario, senhaUsuario) values(?,?,?)";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setString(1, usuario.getEmailUsuario());
			statement.setString(2, usuario.getNomeUsuario());
			statement.setString(3, usuario.getSenhaUsuario());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Excluir um usuário
	
	public void delete(Usuario usuario) {
		
		String sql = "DELETE FROM usuario WHERE emailUsuario = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setString(1, usuario.getEmailUsuario());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Editar um usuário
	
	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET nomeUsuario = ?, senhaUsuario = ? WHERE emailUsuario = ?";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setString(1, usuario.getNomeUsuario());
			statement.setString(2, usuario.getSenhaUsuario());
			statement.setString(3, usuario.getEmailUsuario());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Obter um usuário
	
	public Usuario getByEmail(String emailUsuario) {
		Usuario usu = null;
		String sql = "SELECT emailUsuario, nomeUsuario FROM usuario WHERE emailUsuario = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setString(1, emailUsuario);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				usu = new Usuario();
				usu.setEmailUsuario(resultSet.getString(1));
				usu.setNomeUsuario(resultSet.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usu;
	}
	
	// Obter todos os usuários da tabela
	
	public List<Usuario> getAll(){
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT emailUsuario, nomeUsuario FROM usuario ORDER BY emailUsuario";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setEmailUsuario(resultSet.getString(1));
				usuario.setNomeUsuario(resultSet.getString(2));
				
				lista.add(usuario);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
