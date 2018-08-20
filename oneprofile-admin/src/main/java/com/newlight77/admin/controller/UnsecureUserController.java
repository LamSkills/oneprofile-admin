package com.newlight77.admin.controller;

import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/unsecure/users")
public class UnsecureUserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "")
  public UserDto create(
          @RequestBody UserDto user) {
    return userService.save(user);
  }

  @PutMapping(value = "/{username}")
  public UserDto updateByUsername(@PathVariable String username, @RequestBody UserDto user) {
    return userService.save(user);
  }

  @DeleteMapping(value = "/{username}")
  public Long deleteByUsername(@PathVariable String username) {
    return userService.deleteByUsername(username);
  }

  @GetMapping(value = "/{username}")
  public UserDto findById(@PathVariable String username) {
    return userService.findById(username);
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
  public Collection<UserDto> find(@RequestHeader String primary,
                                  @RequestParam String firstname,
                                  @RequestParam String lastname) {
    return userService.find(firstname, lastname);
  }

  @GetMapping(value = "")
  public Collection<UserDto> findAll() {
    return userService.findAll();
  }

}
