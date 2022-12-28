package com.api.matransacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.matransacao.entities.Transacao;
import com.api.matransacao.entities.enums.StatusTransacao;
import com.api.matransacao.services.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource {

	@Autowired
	private TransacaoService service;

	@PostMapping
	public String efetivarTransacao(@RequestBody Transacao obj) {
		String status = service.efetivarTransacao(obj);
		return status;
	}

}
