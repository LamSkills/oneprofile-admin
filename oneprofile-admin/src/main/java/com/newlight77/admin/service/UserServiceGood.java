package com.newlight77.admin.service;

import com.newlight77.admin.neo4j.User;
import com.newlight77.admin.repository.UserRepositoryGood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceGood {

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceGood.class);

	private final UserRepositoryGood userRepositoryGood;
	public UserServiceGood(UserRepositoryGood movieRepository) {
		this.userRepositoryGood = movieRepository;
	}


	@Transactional(readOnly = true)
	public Collection<User>  graph(int limit) {
		Collection<User> result = userRepositoryGood.graph(limit);
		return result;
	}
}
