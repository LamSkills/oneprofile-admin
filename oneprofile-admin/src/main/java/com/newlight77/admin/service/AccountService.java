package com.newlight77.admin.service;

import com.newlight77.admin.mapper.AccountMapper;
import com.newlight77.admin.model.AccountDto;
import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.repository.AccountRepository;
import com.newlight77.exception.NotFoundException;
import com.newlight77.right.aspect.Rights;
import com.newlight77.right.model.Right;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public class AccountService {

  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public AccountDto save(AccountDto dto) {
    AccountEntity entity = AccountMapper.from(dto);
    return AccountMapper.to(accountRepository.save(entity));
  }
  public List<AccountDto> saveAll(Iterable<AccountDto> iterable) {
    Iterable<AccountEntity> userEntities = StreamSupport.stream(iterable.spliterator(), false)
            .map(AccountMapper::from)
            .collect(Collectors.toList());
    return StreamSupport.stream(accountRepository.saveAll(userEntities).spliterator(), false)
            .map(AccountMapper::to)
            .collect(Collectors.toList());
  }

  public void deleteById(String id) {
    accountRepository.deleteById(id);
  }

  public AccountDto findById(String id) {
    return accountRepository.findById(id)
            .map(AccountMapper::to)
            .orElseThrow(() -> new NotFoundException("Resource not found"));
  }

  public Page<AccountDto> findAll(Pageable pageable) {
    return accountRepository.findAll(pageable)
            .map(AccountMapper::to);
  }
}
