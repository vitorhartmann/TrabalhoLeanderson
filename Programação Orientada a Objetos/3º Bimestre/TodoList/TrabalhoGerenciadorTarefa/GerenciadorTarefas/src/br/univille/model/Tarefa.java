package br.univille.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Tarefa {
	private int idTarefa;
	private String descTarefa;
	private Date dataAgendada;
	private boolean isFinalizada;
	private int prioridade;
	private Projeto projeto;
	
	public int getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	public String getDescTarefa() {
		return descTarefa;
	}
	public void setDescTarefa(String descTarefa) {
		this.descTarefa = descTarefa;
	}
	
	public Date getDataAgendada() {
		return dataAgendada;
	}
	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}
	
	public Timestamp getDataAgendadaTimestamp() {
		if (dataAgendada == null) 
			return null;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataAgendada);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	public boolean isFinalizada() {
		return isFinalizada;
	}
	public void setFinalizada(boolean isFinalizada) {
		this.isFinalizada = isFinalizada;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Tarefa(int idTarefa, String descTarefa, Date dataAgendada, boolean isFinalizada, int prioridade, Projeto projeto) {
		super();
		this.idTarefa = idTarefa;
		this.descTarefa = descTarefa;
		this.dataAgendada = dataAgendada;
		this.isFinalizada = isFinalizada;
		this.prioridade = prioridade;
		this.projeto = projeto;
	}
	
	public Tarefa() {}
	
	@Override
	public String toString() {
		return "Tarefa:"
				+ "\n Numero: " + idTarefa
				+ "\n Descricao: " + descTarefa
				+ "\n Data agendada: " + dataAgendada
				+ "\n  Situacao: " + isFinalizada
				+ "\n Prioridade: " + prioridade
				+ "\n Id do projeto: " + projeto.getIdProjeto();
	}
	
	
}
