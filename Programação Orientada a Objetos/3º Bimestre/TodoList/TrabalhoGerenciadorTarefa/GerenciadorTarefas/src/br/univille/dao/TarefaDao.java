package br.univille.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.univille.model.Projeto;
import br.univille.model.Tarefa;
import br.univille.model.Usuario;

public class TarefaDao extends Dao {
	
	// Inserir uma tarefa
	
	public void insert(Tarefa tarefa) {

		String sql = "INSERT INTO tarefa(idTarefa, descTarefa, dataAgendada, prioridade, projetoIdProjeto) values(?,?,?,?,?)";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setInt(1, tarefa.getIdTarefa());
			statement.setString(2, tarefa.getDescTarefa());
			statement.setTimestamp(3, tarefa.getDataAgendadaTimestamp());
			statement.setInt(4, tarefa.getPrioridade());
			statement.setInt(5, tarefa.getProjeto().getIdProjeto());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Excluir uma tarefa
	
	public void delete(Tarefa tarefa) {
		
		String sql = "DELETE FROM tarefa WHERE idTarefa = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setInt(1, tarefa.getIdTarefa());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Editar uma tarefa
	
	public void update(Tarefa tarefa) {
		String sql = "UPDATE tarefa SET descTarefa = ?, dataAgendada = ?, isFinalizada = ?, prioridade = ?, projetoIdProjeto = ?"
				+ " WHERE idTarefa = ?";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setString(1, tarefa.getDescTarefa());
			statement.setTimestamp(2, tarefa.getDataAgendadaTimestamp());
			statement.setBoolean(3, tarefa.isFinalizada());
			statement.setInt(4, tarefa.getPrioridade());
			statement.setInt(5, tarefa.getProjeto().getIdProjeto());
			statement.setInt(6, tarefa.getIdTarefa());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Obter uma tarefa
	
	public Tarefa getById(int idTarefa) {
		Tarefa tar = null;
		
		String sql = "SELECT tarefa.idTarefa, tarefa.descTarefa, tarefa.dataAgendada, tarefa.isFinalizada, tarefa.prioridade, "
				+ " projeto.IdProjeto, projeto.descProjeto, usuario.emailUsuario, usuario.nomeUsuario"
				+ " FROM tarefa"
				+ " INNER JOIN projeto ON projeto.idProjeto = tarefa.projetoIdProjeto"
				+ " INNER JOIN usuario ON usuario.emailUsuario = projeto.usuarioEmailUsuario"
				+ " WHERE idTarefa = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setInt(1, idTarefa);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				tar = new Tarefa();
				tar.setIdTarefa(resultSet.getInt(1));
				tar.setDescTarefa(resultSet.getString(2));
				tar.setDataAgendada(resultSet.getTimestamp(3));
				tar.setFinalizada(resultSet.getBoolean(4));
				tar.setPrioridade(resultSet.getInt(5));
				
				Projeto projeto = new Projeto();
				projeto.setIdProjeto(resultSet.getInt(6));
				projeto.setDescProjeto(resultSet.getString(7));
				
				Usuario usuario = new Usuario();
				usuario.setEmailUsuario(resultSet.getString(2));
				usuario.setNomeUsuario(resultSet.getString(3));
				
				projeto.setUsuario(usuario);
				tar.setProjeto(projeto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tar;
	}
	
	// Obter todas as tarefas da tabela
	
	public List<Tarefa> getAll(){
		List<Tarefa> lista = new ArrayList<>();
		String sql = "SELECT tarefa.idTarefa, tarefa.descTarefa, tarefa.dataAgendada, tarefa.isFinalizada, tarefa.prioridade, "
				+ " projeto.IdProjeto, projeto.descProjeto, usuario.emailUsuario, usuario.nomeUsuario"
				+ " FROM tarefa"
				+ " INNER JOIN projeto ON projeto.idProjeto = tarefa.projetoIdProjeto"
				+ " INNER JOIN usuario ON usuario.emailUsuario = projeto.usuarioEmailUsuario";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setIdTarefa(resultSet.getInt(1));
				tarefa.setDescTarefa(resultSet.getString(2));
				tarefa.setDataAgendada(resultSet.getTimestamp(3));
				tarefa.setFinalizada(resultSet.getBoolean(4));
				tarefa.setPrioridade(resultSet.getInt(5));
				
				Projeto projeto = new Projeto();
				projeto.setIdProjeto(resultSet.getInt(6));
				projeto.setDescProjeto(resultSet.getString(7));
				
				Usuario usuario = new Usuario();
				usuario.setEmailUsuario(resultSet.getString(2));
				usuario.setNomeUsuario(resultSet.getString(3));
				
				projeto.setUsuario(usuario);
				tarefa.setProjeto(projeto);
				
				lista.add(tarefa);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	// Obter todas as tarefas do usuário
	
		public List<Tarefa> getTarefasUsuario(Usuario usuario){
			List<Tarefa> lista = new ArrayList<>();
			String sql = "SELECT tarefa.idTarefa, tarefa.descTarefa, tarefa.dataAgendada, tarefa.isFinalizada, tarefa.prioridade, "
					+ " projeto.IdProjeto, projeto.descProjeto, usuario.emailUsuario, usuario.nomeUsuario"
					+ " FROM tarefa"
					+ " INNER JOIN projeto ON projeto.idProjeto = tarefa.projetoIdProjeto"
					+ " INNER JOIN usuario ON usuario.emailUsuario = projeto.usuarioEmailUsuario"
					+ " WHERE usuario.emailUsuario = ?";
			
			try(Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(sql)) {
				
				statement.setString(1, usuario.getEmailUsuario());
				
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					Tarefa tarefa = new Tarefa();
					tarefa.setIdTarefa(resultSet.getInt(1));
					tarefa.setDescTarefa(resultSet.getString(2));
					tarefa.setDataAgendada(resultSet.getTimestamp(3));
					tarefa.setFinalizada(resultSet.getBoolean(4));
					tarefa.setPrioridade(resultSet.getInt(5));
					
					Projeto projeto = new Projeto();
					projeto.setIdProjeto(resultSet.getInt(6));
					projeto.setDescProjeto(resultSet.getString(7));
					
					Usuario usu = new Usuario();
					usu.setEmailUsuario(resultSet.getString(2));
					usu.setNomeUsuario(resultSet.getString(3));
					
					projeto.setUsuario(usu);
					tarefa.setProjeto(projeto);
					
					lista.add(tarefa);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return lista;
		}
	
}
