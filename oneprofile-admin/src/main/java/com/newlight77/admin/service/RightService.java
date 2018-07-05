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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public class RightService {

  private RightRepository rightRepository;

  public RightService(RightRepository roleRepository) {
    this.rightRepository = roleRepository;
  }

  @Rights(rights = Right.ADMIN_WRITE)
  public RightDto save(RightDto dto) {
    RightEntity entity = RightMapper.from(dto);
    return RightMapper.to(rightRepository.save(entity));
  }
  @Rights(rights = Right.ADMIN_WRITE)
  public List<RightDto> saveAll(Iterable<RightDto> iterable) {
    Iterable<RightEntity> userEntities = StreamSupport.stream(iterable.spliterator(), false)
            .map(RightMapper::from)
            .collect(Collectors.toList());
    return StreamSupport.stream(rightRepository.saveAll(userEntities).spliterator(), false)
            .map(RightMapper::to)
            .collect(Collectors.toList());
  }

  @Rights(rights = Right.ADMIN_READ)
  public void deleteById(String id) {
    rightRepository.deleteById(id);
  }

  @Rights(rights = Right.ADMIN_READ)
  public RightDto findById(String id) {
    return rightRepository.findById(id)
            .map(RightMapper::to)
            .orElseThrow(() -> new NotFoundException("Resource not found"));
  }

  @Rights(rights = Right.ADMIN_READ)
  public Page<RightDto> findAll(Pageable pageable) {
    return rightRepository.findAll(pageable)
            .map(RightMapper::to);
  }
}
