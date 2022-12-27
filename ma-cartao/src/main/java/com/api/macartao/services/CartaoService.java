package com.api.macartao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.macartao.entities.Cartao;
import com.api.macartao.entities.dtos.CartaoDto;
import com.api.macartao.exception.CartaoException;
import com.api.macartao.repositories.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	public CartaoDto criar(CartaoDto dto) {

		Cartao entity = new Cartao();
		dto.setSaldo(500.00);
		dto.setSenha(dto.getSenha()==null? geradorDeSenha():dto.getSenha());
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
			senha.append(caracteres[posicao]);		}
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

}
