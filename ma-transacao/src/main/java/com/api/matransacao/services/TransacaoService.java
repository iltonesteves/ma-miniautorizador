package com.api.matransacao.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.matransacao.entities.Cartao;
import com.api.matransacao.entities.Transacao;
import com.api.matransacao.entities.enums.StatusTransacao;

@Service
public class TransacaoService {

	@Value("${ma-cartao.host}")
	private String cartaoHost;

	@Autowired
	private RestTemplate restTemplate;

	public String efetivarTransacao(Transacao transacao) {
		ResponseEntity<String> result = restTemplate.postForEntity(cartaoHost + "/cartoes/"
				+ transacao.getNumeroCartao() + "/" + transacao.getSenhaCartao() + "/" + transacao.getValor(), null,
				String.class);
		return result.getBody();
	}

}
