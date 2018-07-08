package com.newlight77.admin.service;

import com.newlight77.admin.mapper.RightMapper;
import com.newlight77.admin.model.RightDto;
import com.newlight77.admin.neo4j.RightEntity;
import com.newlight77.admin.repository.RightRepository;
import com.newlight77.exception.NotFoundException;
import com.newlight77.right.aspect.Rights;
import com.newlight77.right.model.Right;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public class RightService {

  private RightRepository rightRepository;

  public RightService(RightRepository roleRepository) {
    this.rightRepository = roleRepository;
  }

  public RightDto save(RightDto dto) {
    RightEntity entity = RightMapper.from(dto);
    return RightMapper.to(rightRepository.save(entity));
  }

  public List<RightDto> saveAll(List<RightDto> rights) {
    Iterable<RightEntity> userEntities = rights.stream()
            .map(RightMapper::from)
            .collect(Collectors.toList());
    return StreamSupport.stream(rightRepository.saveAll(userEntities).spliterator(), false)
            .map(RightMapper::to)
            .collect(Collectors.toList());
  }

  public void deleteByPrimaryAndSecondary(String primaryKey, String secondaryKey) {
    rightRepository.deleteByPrimaryAndSecondary(primaryKey, secondaryKey);
  }

  public RightDto findById(String id) {
    return rightRepository.findById(id)
            .map(RightMapper::to)
            .orElseThrow(() -> new NotFoundException("Resource not found"));
  }

  public Page<RightDto> findAll(Pageable pageable) {
    return rightRepository.findAll(pageable)
            .map(RightMapper::to);
  }

  public Collection<RightDto> findByPrimaryAndSecondary(String primaryKey, String secondaryKey) {
    Collection<RightEntity> entities =
            rightRepository.findByPrimaryAndSecondary(primaryKey, secondaryKey, 100);
    return entities.stream().map(e -> RightMapper.to(e)).collect(Collectors.toSet());
  }

}
