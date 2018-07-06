package com.newlight77.admin.controller;

import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "")
  public String findAll() {
    return "Users";
  }

  @PostMapping(value = "")
  public UserDto create(
          @RequestHeader String username,
          @RequestBody UserDto user) {
    return userService.save(username, user);
  }

  @GetMapping(value = "/{id}")
  public UserDto findById(String id) {
    return userService.findById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteById(String id) {
    userService.deleteById(id);
  }

  @GetMapping(value = "/page")
  public Page<UserDto> findAll(Pageable pageable) {
    return userService.findAll(pageable);
  }

  @GetMapping(value = "", params = {"username"})
  public Collection<UserDto> findByUsername(@RequestParam String username) {
    return userService.findByUsername(username);
  }

  @GetMapping(value = "", params = {"firstname", "lastname"})
  public Collection<UserDto> find(@RequestParam String firstname, @RequestParam String lastname) {
    return userService.find(firstname, lastname);
  }

  @GetMapping(value = "/roles")
  public Collection<UserDto> userRoles() {
    return userService.userRoles();
  }

  @GetMapping(value = "/accounts")
  public Collection<UserDto> userAccounts() {
    return userService.userAccounts();
  }

}
