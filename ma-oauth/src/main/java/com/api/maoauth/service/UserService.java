package com.api.maoauth.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.macartao.entities.Cartao;
import com.api.macartao.entities.dtos.CartaoDto;
import com.api.maoauth.entities.User;
import com.api.maoauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			log.error("Email não encontrado " + email);
			throw new IllegalArgumentException("Email não encontrado");
		}

		return user;

	}

}
