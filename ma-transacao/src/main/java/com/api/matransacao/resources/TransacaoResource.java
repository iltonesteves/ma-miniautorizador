package com.api.matransacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.matransacao.entities.Transacao;
import com.api.matransacao.services.TransacaoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource {

	@Autowired
	private TransacaoService service;

	@HystrixCommand(fallbackMethod = "efetivarTransacaoAlternativo")
	@PostMapping
	public String efetivarTransacao(@RequestBody Transacao obj) {
		String status = service.efetivarTransacao(obj);
		return status;
	}

	public String efetivarTransacaoAlternativo(Transacao obj) {
		return "Estamos em manutenção- aguarde 1 minuto!";
	}

}
