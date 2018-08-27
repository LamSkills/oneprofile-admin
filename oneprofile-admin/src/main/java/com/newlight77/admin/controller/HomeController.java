package com.newlight77.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

  @RequestMapping(value = "ping", method = RequestMethod.GET)
  public String home() {
    return "pong";
  }

}
