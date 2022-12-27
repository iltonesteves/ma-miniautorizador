package com.api.macartao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name="tb_cartao")
public class Cartao implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private Long numeroCartao;
	
	@NotNull
	@Column(precision=8, scale=2) 
	private Double saldo;
	
	@NotNull
	@Column(name = "senha")
	private int senha;
	
	
	
	public Long getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public Cartao() {
		
	}
	public Cartao(Long numeroCartao, Double saldo, int senha) {
		super();
		this.numeroCartao = numeroCartao;
		this.saldo = saldo;
		this.senha = senha;
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(numeroCartao, other.numeroCartao);
	}




	
	
	

}
