package com.api.maoauth.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.maoauth.entities.User;
import com.api.maoauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			log.error("Email não encontrado " + username);
			throw new UsernameNotFoundException("Email não encontrado");
		}

		return user;
	}

}
