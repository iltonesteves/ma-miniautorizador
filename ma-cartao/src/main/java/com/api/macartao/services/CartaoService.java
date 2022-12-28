package com.api.macartao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.macartao.entities.Cartao;
import com.api.macartao.entities.dtos.CartaoDto;
import com.api.macartao.entities.enums.StatusTransacao;
import com.api.macartao.exception.CartaoException;
import com.api.macartao.repositories.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	public CartaoDto criar(CartaoDto dto) {

		Cartao entity = new Cartao();
		dto.setSaldo(500.00);
		dto.setSenha(dto.getSenha() == null ? geradorDeSenha() : dto.getSenha());
		dtoToEntity(entity, dto);
		Cartao cartao = repository.save(entity);
		return new CartaoDto(cartao);

	}

	public Double consultarSaldo(Long numeroCartao) {
		Optional<Cartao> entity = repository.findById(numeroCartao);
		Cartao cartao = entity.orElseThrow(() -> new CartaoException("Cartão inexistente"));
		return cartao.getSaldo();
	}

	public int geradorDeSenha() {
		String[] caracteres = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int posicao = (int) (Math.random() * caracteres.length);
			senha.append(caracteres[posicao]);
		}
		return Integer.parseInt(senha.toString());
	}

	public CartaoDto verificaCartaoSeExistente(Long numeroCartao) {
		Optional<Cartao> obj = repository.findById(numeroCartao);
		return obj.isPresent() ? new CartaoDto(obj.get()) : null;

	}

	public void dtoToEntity(Cartao entity, CartaoDto dto) {
		entity.setNumeroCartao(dto.getNumeroCartao());
		entity.setSaldo(dto.getSaldo());
		entity.setSenha(dto.getSenha());

	}

	public StatusTransacao efetivarTransacao(Long numeroCartao, int senhaCartao, Double vlTransacao) {

		return validaTransacao(numeroCartao, senhaCartao, vlTransacao).equals(StatusTransacao.OK)
				? atualizarSaldo(numeroCartao, senhaCartao, vlTransacao)
				: validaTransacao(numeroCartao, senhaCartao, vlTransacao);
	}

	public StatusTransacao validaTransacao(Long numeroCartao, int senhaCartao, Double vlTransacao) {
		Optional<Cartao> entity = repository.findById(numeroCartao);
		StatusTransacao status;
		status = !entity.isPresent() ? StatusTransacao.CARTAO_INEXISTENTE
				: validaSenha(senhaCartao, vlTransacao, entity.get());
		return status;
	}

	public StatusTransacao validaSenha(int senhaCartao, Double vlTransacao, Cartao cartao) {

		return senhaCartao == cartao.getSenha() ? validaValor(vlTransacao, cartao.getSaldo())
				: StatusTransacao.SENHA_INVALIDA;
	}

	public StatusTransacao validaSaldo(Double valor, Double saldo) {
		return valor < saldo ? StatusTransacao.OK : StatusTransacao.SALDO_INSUFICIENTE;

	}

	public StatusTransacao validaValor(Double valor, Double saldo) {
		return (valor == null || valor <= 0) ? StatusTransacao.VALOR_INVALIDO : validaSaldo(valor, saldo);

	}

	public StatusTransacao atualizarSaldo(Long numeroCartao, int senhaCartao, Double vlTransacao) {
		Optional<Cartao> entity = repository.findById(numeroCartao);
		Cartao cartao = entity.get();
		cartao.setSaldo(cartao.getSaldo() - vlTransacao);
		repository.save(cartao);

		return StatusTransacao.OK;
	}

}
