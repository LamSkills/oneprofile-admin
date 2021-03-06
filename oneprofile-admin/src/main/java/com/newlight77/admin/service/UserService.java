package com.newlight77.admin.service;


import com.newlight77.admin.mapper.UserMapper;
import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.admin.repository.UserRepository;
import com.newlight77.exception.ConflictException;
import com.newlight77.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(UserDto user) {
        UserEntity entity = UserMapper.from(user);
        try {
            return UserMapper.to(userRepository.save(entity));
        } catch(Exception ex) {
            throw new ConflictException(ex.getMessage());
        }
    }

    public List<UserDto> saveAll(Iterable<UserDto> iterable) {
        Iterable<UserEntity> userEntities = StreamSupport.stream(iterable.spliterator(), false)
                .map(UserMapper::from)
                .collect(Collectors.toList());
        return StreamSupport.stream(userRepository.saveAll(userEntities).spliterator(), false)
                .map(UserMapper::to)
                .collect(Collectors.toList());
    }

    public Long deleteByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }

    public UserDto findById(String id) {
        return userRepository.findById(id)
                .map(UserMapper::to)
                .orElseThrow(() -> new NotFoundException("Resource not found"));
    }

    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserMapper::to);
    }

    public List<UserDto> findAll() {
        Iterable<UserEntity> users = userRepository.findAll();
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

    public List<UserDto> find(String firstname, String lastname) {
        log.info("findByFirstname with firstname={} lastname={} username={}", firstname, lastname);
        return userRepository.findByFirstnameAndLastname(firstname, lastname)
                .stream()
                .map(UserMapper::to)
                .collect(Collectors.toList());
    }

}
