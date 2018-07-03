package com.newlight77.admin.service;

import com.newlight77.admin.neo4j.RightEntity;
import com.newlight77.admin.repository.RightRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class RightService {

  private RightRepository rightRepository;

  public RightService(RightRepository roleRepository) {
    this.rightRepository = roleRepository;
  }

  public Iterable<RightEntity> findAll() {
    return rightRepository.findAll();
  }

  public RightEntity save(RightEntity s) {
    return rightRepository.save(s);
  }

  public Optional<RightEntity> findById(String id) {
    return rightRepository.findById(id);
  }

  public void deleteById(String id) {
    rightRepository.deleteById(id);
  }

  public void delete(RightEntity roleEntity) {
    rightRepository.delete(roleEntity);
  }
}
