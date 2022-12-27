package com.api.macartao.entities.dtos;

import java.util.Objects;

import com.api.macartao.entities.Cartao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



public class CartaoDto  {

//	@NotNull(message = "campo número do cartão é obrigatório.")
	private Long numeroCartao;
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

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	@JsonInclude(Include.NON_NULL)
	private Double saldo;
//	@NotNull(message = "campo senha do cartão é obrigatório.")
	private Integer senha;

	public CartaoDto() {

	}

	public CartaoDto(Long numeroCartao, Double saldo, Integer senha) {
		this.numeroCartao = numeroCartao;
		this.saldo = saldo;
		this.senha = senha;

	}

	public CartaoDto(Cartao entity) {

		numeroCartao = entity.getNumeroCartao();
		saldo = entity.getSaldo();
		senha = entity.getSenha();

	}

	public CartaoDto(Long numeroCartao, Integer senha) {
		this.numeroCartao = numeroCartao;
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
		CartaoDto other = (CartaoDto) obj;
		return Objects.equals(numeroCartao, other.numeroCartao);
	}

}
