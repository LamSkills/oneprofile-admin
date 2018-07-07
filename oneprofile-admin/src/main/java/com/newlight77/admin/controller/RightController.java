package com.newlight77.admin.controller;

import com.newlight77.right.model.RightDto;
import com.newlight77.right.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rights")
public class RightController {

  @Autowired
  private RightService rightService;

  @GetMapping(value = "")
  public String findAll() {
    return "rights";
  }

  @PostMapping(value = "")
  public RightDto create(@RequestBody RightDto rightDto) {
    return rightService.addRight(rightDto);
  }

  @GetMapping(value = "/{primary}/{secondary}")
  public Collection<RightDto> findById(@PathVariable String primary,
                                       @PathVariable String secondary) {
    return rightService.findByPrimaryAndSecondary(primary, secondary);
  }

  @DeleteMapping(value = "/{primary}/{secondary}")
  public void deleteByPrimaryAndSeconary(@PathVariable String primary,
                                         @PathVariable String secondary) {
    rightService.deleteByPrimaryAndSecondary(primary, secondary);
  }

}
