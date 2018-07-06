package com.newlight77.admin.mapper;

import com.newlight77.admin.model.AccountDto;
import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.neo4j.UserEntity;
import org.assertj.core.util.Sets;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

  public static UserDto to(UserEntity entity) {
    Set<AccountDto> accounts = Sets.newHashSet();
    if (!CollectionUtils.isEmpty(entity.getAccounts())) {
      accounts = entity.getAccounts().stream()
              .map(AccountMapper::to).collect(Collectors.toSet());
    }
    return UserDto.builder()
            .firstname(entity.getFirstname())
            .lastname(entity.getLastname())
            .username(entity.getUsername())
            .accounts(accounts)
            .build();
  }

  public static UserEntity from(UserDto dto) {
    Set<AccountEntity> accountEntities = Sets.newHashSet();
    if (!CollectionUtils.isEmpty(dto.getAccounts())) {
      accountEntities = dto.getAccounts().stream().map(AccountMapper::from).collect(Collectors.toSet());
    }
    return UserEntity.builder()
            .firstname(dto.getFirstname())
            .lastname(dto.getLastname())
            .username(dto.getUsername())
            .accounts(accountEntities)
            .build();
  }
}
