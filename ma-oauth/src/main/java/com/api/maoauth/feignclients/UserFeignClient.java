package com.api.maoauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.maoauth.entities.User;

@Component
@FeignClient(name = "ma-user", path = "/users")
public interface UserFeignClient {

	@GetMapping("/search{id}")
	ResponseEntity<User> findByEmail(@RequestParam String email);

}
