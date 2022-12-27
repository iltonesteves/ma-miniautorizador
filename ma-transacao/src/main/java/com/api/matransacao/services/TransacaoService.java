package com.api.matransacao.services;

import org.springframework.stereotype.Service;

import com.api.matransacao.entities.Transacao;

@Service
public class TransacaoService {
	
	public Transacao getTransacao(Long numeroCartao, Double valor,  int senhaCartao) {
		return new Transacao(1L,200.0, 2);
		
	}

}
