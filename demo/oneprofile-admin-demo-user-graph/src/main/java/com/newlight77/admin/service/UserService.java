package com.newlight77.admin.service;


import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.admin.mapper.UserMapper;
import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        Iterable<UserEntity> users = userRepository.findAll(2);
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserMapper::to)
                .collect(Collectors.toList());
    }

    public List<UserDto> findByUsername(String username) {
        log.info("findByFirstname with username={}", username);
        return userRepository.findByUsername(username)
                .stream()
                .map(UserMapper::to)
                .collect(Collectors.toList());
    }
}
