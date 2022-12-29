package com.api.matransacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name="ma-cartao")
@EnableFeignClients
@SpringBootApplication
public class MaTransacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaTransacaoApplication.class, args);
	}

}
