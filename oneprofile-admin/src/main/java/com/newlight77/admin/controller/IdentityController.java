package com.newlight77.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class IdentityController {

  @RequestMapping("/me")
  public String user(Principal principal) {
    return principal.getName();
  }
}
