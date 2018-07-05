package com.newlight77.admin.controller;

import com.newlight77.admin.model.RightDto;
import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/roles")
public class RolesController {

  @Autowired
  private RoleService roleService;

  @GetMapping(value = "")
  public String findAll() {
    return "roles";
  }

  @PostMapping(value = "")
  public RoleDto create(@RequestBody RoleDto user) {
    return roleService.save(user);
  }

  @GetMapping(value = "/{id}")
  public RoleDto findById(String id) {
    return roleService.findById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteById(String id) {
    roleService.deleteById(id);
  }

  @GetMapping(value = "/page")
  public Page<RoleDto> findAll(Pageable pageable) {
    return roleService.findAll(pageable);
  }

  @GetMapping(value = "/{id}/rights")
  public Collection<RightDto> rightsByRole(@RequestParam String id) {
    return roleService.findById(id).getRights();
  }

}
