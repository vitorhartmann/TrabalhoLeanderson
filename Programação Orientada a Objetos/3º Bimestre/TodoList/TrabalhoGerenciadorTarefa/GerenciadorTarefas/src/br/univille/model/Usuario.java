package br.univille.model;

public class Usuario {
	private String emailUsuario;
	private String nomeUsuario;
	private String senhaUsuario;
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public Usuario(String emailUsuario, String nomeUsuario, String senhaUsuario) {
		super();
		this.emailUsuario = emailUsuario;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
	}
	
	public Usuario() {}
	
	@Override
	public String toString() {
		return "Usuario: "
				+ "\n Email: " + emailUsuario
				+ "\n Nome: " + nomeUsuario;
	}
	
}
