package com.api.maeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaEurekaServerApplication.class, args);
	}

}
