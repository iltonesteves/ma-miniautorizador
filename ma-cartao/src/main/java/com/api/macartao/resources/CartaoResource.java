package com.api.macartao.resources;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.macartao.entities.dtos.CartaoDto;
import com.api.macartao.entities.enums.StatusTransacao;
import com.api.macartao.services.CartaoService;

@RefreshScope
@RestController
@RequestMapping("/cartoes")
public class CartaoResource {

	private Logger log = LoggerFactory.getLogger(CartaoResource.class);
	@Autowired
	private CartaoService service;

//	@Value("${test-config}")
//	private String TestConfig;

	@Autowired
	private Environment env;

	@GetMapping("/{numeroCartao}")
	public ResponseEntity<Double> consultaSaldo(@Valid @PathVariable Long numeroCartao) {

		try {
			return ResponseEntity.ok(service.consultarSaldo(numeroCartao));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
//		log.info("Configuração.......   " + TestConfig);
		return ResponseEntity.noContent().build();
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
		log.info("Porta " + env.getProperty("local.server.port"));
		return service.efetivarTransacao(numeroCartao, senhaCartao, vlTransacao);

	}
}
