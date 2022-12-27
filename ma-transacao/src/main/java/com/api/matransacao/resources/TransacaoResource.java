package com.api.matransacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.matransacao.entities.Transacao;
import com.api.matransacao.services.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource {
	
	@Autowired
	private TransacaoService service;

	@GetMapping
	public ResponseEntity<Transacao> testarTransacao(@RequestBody Transacao obj) {
	Transacao transacao = service.getTransacao(null, null, 0);
	return ResponseEntity.ok(transacao);
	}


}
