package com.api.matransacao.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Transacao implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	@NotNull	
	private Long numeroCartao;
	@NotNull	
	private Double valor;
	@NotNull	
	private int senhaCartao;
	

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(int senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public Transacao() {

	}

	public Transacao(@NotNull Long numeroCartao, @NotNull Double valor, @NotNull int senhaCartao) {
		super();
		this.numeroCartao = numeroCartao;
		this.valor = valor;
		this.senhaCartao = senhaCartao;
	
	}
}