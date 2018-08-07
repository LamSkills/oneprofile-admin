package com.newlight77.admin.controller;

import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.service.UserService;
import com.newlight77.right.aspect.Rights;
import com.newlight77.right.model.Right;
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

  @Rights(rights = Right.ADMIN_WRITE)
  @PostMapping(value = "")
  public UserDto create(
          @RequestHeader String primary,
          @RequestBody UserDto user) {
    return userService.save(user);
  }

  @Rights(rights = Right.ADMIN_DELETE)
  @DeleteMapping(value = "/{id}")
  public void deleteById(@RequestHeader String primary,
                         String id) {
    userService.deleteById(id);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "/{id}")
  public UserDto findById(@RequestHeader String primary,
                          String id) {
    return userService.findById(id);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "/page")
  public Page<UserDto> findAll(@RequestHeader String primary,
                               Pageable pageable) {
    return userService.findAll(pageable);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "", params = {"username"})
  public Collection<UserDto> findByUsername(@RequestHeader String primary,
                                            @RequestParam String username) {
    return userService.findByUsername(username);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "", params = {"firstname", "lastname"})
  public Collection<UserDto> find(@RequestHeader String primary,
                                  @RequestParam String firstname,
                                  @RequestParam String lastname) {
    return userService.find(firstname, lastname);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "/roles")
  public Collection<UserDto> userRoles(@RequestHeader String primary) {
    return userService.userRoles();
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "/accounts")
  public Collection<UserDto> userAccounts(@RequestHeader String primary) {
    return userService.userAccounts();
  }

  @GetMapping(value = "/unsecure")
  public Collection<UserDto> findAll() {
    return userService.findAll();
  }

}
