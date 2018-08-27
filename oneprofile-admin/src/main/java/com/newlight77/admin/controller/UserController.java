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
@RequestMapping("/api/users")
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

  @Rights(rights = Right.ADMIN_WRITE)
  @PutMapping(value = "/{username}")
  public UserDto updateByUsername(
          @RequestHeader String primary,
          @PathVariable String username,
          @RequestBody UserDto user) {
    return userService.save(user);
  }

  @Rights(rights = Right.ADMIN_DELETE)
  @DeleteMapping(value = "/{username}")
  public Long deleteByUsername(@RequestHeader String primary,
                               @PathVariable String username) {
    return userService.deleteByUsername(username);
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
  @GetMapping(value = "")
  public Collection<UserDto> findAll(@RequestHeader String primary) {
    return userService.findAll();
  }

}
