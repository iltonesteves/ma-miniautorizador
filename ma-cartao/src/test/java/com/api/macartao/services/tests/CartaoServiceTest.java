package com.api.macartao.services.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.macartao.entities.Cartao;
import com.api.macartao.entities.dtos.CartaoDto;
import com.api.macartao.entities.enums.StatusTransacao;
import com.api.macartao.repositories.CartaoRepository;
import com.api.macartao.services.CartaoService;

@SpringBootTest
public class CartaoServiceTest {

	private Logger log = LoggerFactory.getLogger(CartaoServiceTest.class);

	@Autowired
	private CartaoService service;

	@Autowired
	private CartaoRepository cartaoRepository;

	@BeforeEach
	void init() {
		log.info("entrei init ");

		Cartao cartao = new Cartao();
		cartao.setNumeroCartao(0000000000000000L);
		cartao.setSaldo(500.00);
		cartao.setSenha(6653);
		cartaoRepository.save(cartao);
		log.info("sai init ");
	}
	@AfterEach
	void teardown() {
		cartaoRepository.deleteById(0000000000000000L);
		;
	}

	@Test
	void deveCriarCartaoComSucesso() {
		log.info("entrei deveCriarCartaoComSucesso ");

		CartaoDto cartaoDto = new CartaoDto();
		cartaoDto.setNumeroCartao(0000000000000000L);
		cartaoDto.setSenha(6653);
		cartaoDto = service.criar(cartaoDto);
		assertEquals(500, cartaoDto.getSaldo());
	}

	@Test
	void deveVerificaCartaoSeExiste() {
		log.info("entrei deveVerificaCartaoSeExiste ");
		CartaoDto cartaoDto = new CartaoDto();
		cartaoDto.setNumeroCartao(0000000000000000L);
		CartaoDto cartaoDtoSalvo = service.verificaCartaoSeExistente(cartaoDto.getNumeroCartao());
		assertEquals(cartaoDto, cartaoDtoSalvo);
	}

	@Test
	void deveConsultarSaldo() {
		log.info("entrei deveConsultarSaldo ");
		Cartao cartao = new Cartao();
		cartao.setNumeroCartao(0000000000000000L);
		cartao.setSaldo(500.00);
		cartaoRepository.save(cartao);
		CartaoDto cartaoDto = new CartaoDto();
		cartaoDto.setNumeroCartao(0000000000000000L);

		Double saldo = service.consultarSaldo(cartaoDto.getNumeroCartao());
		assertEquals(500, saldo);
	}
	
	@Test
	void deveEfetuarTransacao_cartaoInexistente() {
		StatusTransacao status = service.efetivarTransacao(0000000000000001L, 6653, 5.0);
		log.info("sai deveEfetuarTransacao_cartaoInexistente "+status.name());
		assertEquals(StatusTransacao.CARTAO_INEXISTENTE.name(), status.name());
		
	}

	@Test
	void deveEfetuarTransacao_senhaInvalida() {
		StatusTransacao status = service.efetivarTransacao(0000000000000000L, 6654, 5.0);
		log.info("sai deveEfetuarTransacao_senhaInvalida "+status.name());
		assertEquals(StatusTransacao.SENHA_INVALIDA.name(), status.name());
		
	}

	@Test
	void deveEfetuarTransacao_saldoInsuficiente() {
		StatusTransacao status = service.efetivarTransacao(0000000000000000L, 6653, 501.0);
		log.info("sai deveEfetuarTransacao_saldoInsuficiente "+status.name());
		assertEquals(StatusTransacao.SALDO_INSUFICIENTE.name(), status.name());
		
	}

	@Test
	void deveEfetuarTransacao_valorInvalido() {
		StatusTransacao status = service.efetivarTransacao(0000000000000000L, 6653, null);
		log.info("sai deveEfetuarTransacao_valorInvalido "+status.name());
		assertEquals(StatusTransacao.VALOR_INVALIDO.name(), status.name());
		
	}

	@Test
	void deveEfetuarTransacao_OK() {
		StatusTransacao status = service.efetivarTransacao(0000000000000000L, 6653, 20.0);
		log.info("sai deveEfetuarTransacao_OK "+status.name());
		assertEquals(StatusTransacao.OK.name(), status.name());
		
	}

}
