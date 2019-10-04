// Aluno: Vitor A. Hartmann
// Sistemas da Informação
// Matéria: Sistemas Operacionais



package br.univille.main;

import java.util.Date;
import java.util.List;

import br.univille.dao.ProjetoDao;
import br.univille.dao.TarefaDao;
import br.univille.dao.UsuarioDao;
import br.univille.model.Projeto;
import br.univille.model.Tarefa;
import br.univille.model.Usuario;

public class Main {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDao();
		ProjetoDao projetoDao = new ProjetoDao();
		TarefaDao tarefaDao = new TarefaDao();
		
		String email = "vitorhartmann@hotmail.com";
		String senha = "senhadificil";

		Usuario usuario = usuarioDao.getByEmail(email);


		
		if (usuario == null) { // Caso inexistente, criar novo
			
			Usuario novoUsuario = new Usuario(email, "Vitor Hartmann", senha);
			usuarioDao.insert(novoUsuario);
			
			// Comando pra dar select no usuario cadastrado
			
			usuario = usuarioDao.getByEmail(novoUsuario.getEmailUsuario());
			
			// Verificacao se o usu�rio � null, se foi criado ou n�o
			
			if (usuario.getEmailUsuario() == null){
				System.out.println("Erro na criacao do usuario");
			}
		}
		
		// Altera a senha do usu�rio
		
		if (usuario.getSenhaUsuario() != senha) {
			usuario.setSenhaUsuario(senha);
			
			usuarioDao.update(usuario);
		}

		System.out.println(usuario.toString());
		
		// Cria um projeto
		
		Projeto projeto = new Projeto(1, "Compras", usuario);
		projetoDao.insert(projeto);
		
		System.out.println(projeto.toString());
		
		// Cria as tarefas
		
		Date data = new Date();
		
		Tarefa tarefa1 = new Tarefa(1, "Comprar banana", data, false, 1, projeto);
		tarefaDao.insert(tarefa1);
		
		Tarefa tarefa2 = new Tarefa(2, "Comprar ma��s", data, false, 1, projeto);
		tarefaDao.insert(tarefa2);
		
		// Busca os dados das tarefas criadas
		
		tarefa1 = tarefaDao.getById(tarefa1.getIdTarefa());
		tarefa2 = tarefaDao.getById(tarefa2.getIdTarefa());
		
		// Finaliza as tarefas e as atualiza no banco de dados
		
		tarefa1.setFinalizada(true);
		tarefaDao.update(tarefa1);
		
		tarefa2.setFinalizada(true);
		tarefaDao.update(tarefa2);
		
		// Exbe a lista de tarefas do usu�rio
		
		List<Tarefa> listaTarefasUsuario = tarefaDao.getTarefasUsuario(usuario);
		
		System.out.println("\nLista de tarefas do usu�rio: ");
		
		for (Tarefa tar : listaTarefasUsuario) {
			System.out.println(tar.toString());
		}
		
		// Apaga a tarefa
		
		tarefaDao.delete(tarefa1);
		
		// Exbe a lista de tarefas do usu�rio atualizada
		
		listaTarefasUsuario = tarefaDao.getTarefasUsuario(usuario);
		
		System.out.println("\nLista atualizada de tarefas do usu�rio: ");
				
		for (Tarefa tar : listaTarefasUsuario) {
			System.out.println(tar.toString());
		}
	}

}
