package com.newlight77.admin.controller;

import com.newlight77.admin.model.RightDto;
import com.newlight77.admin.service.RightService;
import com.newlight77.right.aspect.Rights;
import com.newlight77.right.model.Right;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/rights")
public class RightController {

  @Autowired
  private RightService hasRightService;

  @Rights(rights = Right.ADMIN_WRITE)
  @PostMapping(value = "")
  public RightDto create(@RequestHeader String primary,
                         @RequestBody RightDto rightDto) {
    return hasRightService.save(rightDto);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "")
  public Page<RightDto> findAll(Pageable pageable) {
    return hasRightService.findAll(pageable);
  }

  @Rights(rights = Right.ADMIN_READ)
  @GetMapping(value = "/{primaryKey}/{secondaryKey}")
  public Collection<RightDto> findById(@RequestHeader String primary,
                                       @PathVariable String primaryKey,
                                       @PathVariable String secondaryKey) {
    return hasRightService.findByPrimaryAndSecondary(primaryKey, secondaryKey);
  }

  @Rights(rights = Right.ADMIN_DELETE)
  @DeleteMapping(value = "/{primaryKey}/{secondaryKey}")
  public void deleteByPrimaryAndSeconary(@RequestHeader String primary,
                                         @PathVariable String primaryKey,
                                         @PathVariable String secondaryKey) {
    hasRightService.deleteByPrimaryAndSecondary(primaryKey, secondaryKey);
  }

}
