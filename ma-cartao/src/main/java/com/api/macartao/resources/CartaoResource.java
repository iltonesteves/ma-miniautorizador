package com.api.macartao.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.macartao.entities.dtos.CartaoDto;
import com.api.macartao.entities.enums.StatusTransacao;
import com.api.macartao.services.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoResource {

	@Autowired
	private CartaoService service;

	@GetMapping("/{numeroCartao}")
	public ResponseEntity<Double> consultaSaldo(@Valid @PathVariable Long numeroCartao) {

		try {
			return ResponseEntity.ok(service.consultarSaldo(numeroCartao));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping
	public ResponseEntity<CartaoDto> criar(@Valid @RequestBody CartaoDto dto) {
		CartaoDto cartao = service.verificaCartaoSeExistente(dto.getNumeroCartao());
		return cartao != null
				? ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
						.body(new CartaoDto(cartao.getNumeroCartao(), cartao.getSenha()))
				: ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));

	}

	@PostMapping("/{numeroCartao}/{senhaCartao}/{vlTransacao}")
	public StatusTransacao criarTransacao(@PathVariable Long numeroCartao, @PathVariable int senhaCartao,
			@PathVariable Double vlTransacao) {
		return service.efetivarTransacao(numeroCartao, senhaCartao, vlTransacao);

	}
}
