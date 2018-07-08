package com.newlight77.admin.service;

import com.newlight77.admin.mapper.RoleMapper;
import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.neo4j.RoleEntity;
import com.newlight77.admin.repository.RoleRepository;
import com.newlight77.exception.NotFoundException;
import com.newlight77.right.aspect.Rights;
import com.newlight77.right.model.Right;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public class RoleService {

  private RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public RoleDto save(RoleDto dto) {
    RoleEntity entity = RoleMapper.from(dto);
    return RoleMapper.to(roleRepository.save(entity));
  }
  public List<RoleDto> saveAll(Iterable<RoleDto> iterable) {
    Iterable<RoleEntity> userEntities = StreamSupport.stream(iterable.spliterator(), false)
            .map(RoleMapper::from)
            .collect(Collectors.toList());
    return StreamSupport.stream(roleRepository.saveAll(userEntities).spliterator(), false)
            .map(RoleMapper::to)
            .collect(Collectors.toList());
  }

  public void deleteById(String id) {
    roleRepository.deleteById(id);
  }

  public RoleDto findById(String id) {
    return roleRepository.findById(id)
            .map(RoleMapper::to)
            .orElseThrow(() -> new NotFoundException("Resource not found"));
  }

  public Page<RoleDto> findAll(Pageable pageable) {
    return roleRepository.findAll(pageable)
            .map(RoleMapper::to);
  }

}
