package com.api.mauser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class MaUserApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder senhaEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MaUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("BCRYPT = "+senhaEncoder.encode("123456"));
	}

}
