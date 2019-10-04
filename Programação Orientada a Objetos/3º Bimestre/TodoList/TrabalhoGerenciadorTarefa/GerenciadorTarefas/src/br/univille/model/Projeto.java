package br.univille.model;

public class Projeto {
	private int idProjeto;
	private String descProjeto;
	private Usuario usuario;
	
	public int getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	
	public String getDescProjeto() {
		return descProjeto;
	}
	public void setDescProjeto(String descProjeto) {
		this.descProjeto = descProjeto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Projeto(int idProjeto, String descProjeto, Usuario usuario) {
		super();
		this.idProjeto = idProjeto;
		this.descProjeto = descProjeto;
		this.usuario = usuario;
	}
	
	public Projeto() {}
	
	@Override
	public String toString() {
		return "Projeto: "
				+ "\n Numero: " + idProjeto
				+ "\n Descricao: " + descProjeto
				+ "\n Usuario: " + usuario.getEmailUsuario();
	}
	
}
