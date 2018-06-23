package com.newlight77.admin.service;

import com.newlight77.bhavio.core.entity.user.neo4j.RoleEntity;
import com.newlight77.bhavio.core.repository.user.neo4j.RoleRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class RoleService {

  private RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public Iterable<RoleEntity> findAll() {
    return roleRepository.findAll();
  }

  public RoleEntity save(RoleEntity s) {
    return roleRepository.save(s);
  }

  public Optional<RoleEntity> findById(Long aLong) {
    return roleRepository.findById(aLong);
  }

  public void deleteById(Long aLong) {
    roleRepository.deleteById(aLong);
  }

  public void delete(RoleEntity roleEntity) {
    roleRepository.delete(roleEntity);
  }
}
