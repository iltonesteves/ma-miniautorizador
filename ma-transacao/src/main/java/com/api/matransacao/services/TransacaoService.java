package com.api.matransacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.matransacao.entities.Transacao;
import com.api.matransacao.entities.enums.StatusTransacao;
import com.api.matransacao.feignclients.CartaoFeignClient;

@Service
public class TransacaoService {

//	@Value("${ma-cartao.host}")
//	private String cartaoHost;

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private CartaoFeignClient cartaoFeignClient;

	public String efetivarTransacao(Transacao transacao) {
//		ResponseEntity<String> result = restTemplate.postForEntity(cartaoHost + "/cartoes/"
//				+ transacao.getNumeroCartao() + "/" + transacao.getSenhaCartao() + "/" + transacao.getValor(), null,
//				String.class);
		StatusTransacao result = cartaoFeignClient.criarTransacao(transacao.getNumeroCartao(),
				transacao.getSenhaCartao(),transacao.getValor());
		return result.name();
	}

}
