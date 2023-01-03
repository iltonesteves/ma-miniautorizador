package com.api.maoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MaOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaOauthApplication.class, args);
	}

}
