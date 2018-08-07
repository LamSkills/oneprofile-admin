package com.newlight77.admin.controller;

import com.newlight77.admin.neo4j.User;
import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.admin.service.UserServiceGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/movie")
public class UserControllerGood {

	@Autowired
	private UserServiceGood userServiceGood;

    @GetMapping("/graph")
	public Collection<User> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return userServiceGood.graph(limit == null ? 100 : limit);
	}

}
