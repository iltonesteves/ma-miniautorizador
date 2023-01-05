package com.api.macartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MaCartaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaCartaoApplication.class, args);
	}

}
