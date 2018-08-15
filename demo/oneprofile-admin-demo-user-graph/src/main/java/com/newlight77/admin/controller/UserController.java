package com.newlight77.admin.controller;

import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "")
  public Collection<UserDto> findAll() {
    return userService.findAll();
  }

  @GetMapping(value = "", params = {"username"})
  public Collection<UserDto> findByUsername(@RequestParam String username) {
    return userService.findByUsername(username);
  }

}
