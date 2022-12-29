package com.api.matransacao.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.matransacao.entities.enums.StatusTransacao;

@Component
@FeignClient(name = "ma-cartao", url = "${ma-cartao.host}", path = "/cartoes")
public interface CartaoFeignClient {

	@PostMapping("/{numeroCartao}/{senhaCartao}/{vlTransacao}")
	StatusTransacao criarTransacao(@PathVariable Long numeroCartao, @PathVariable int senhaCartao,
			@PathVariable Double vlTransacao);

}
