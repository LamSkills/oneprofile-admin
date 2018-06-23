package com.newlight77.admin.service;

import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class AccountService {

  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Iterable<AccountEntity> findAll() {
    return accountRepository.findAll();
  }

  public AccountEntity save(AccountEntity s) {
    return accountRepository.save(s);
  }

  public Optional<AccountEntity> findById(Long aLong) {
    return accountRepository.findById(aLong);
  }

  public void deleteById(Long aLong) {
    accountRepository.deleteById(aLong);
  }

  public void delete(AccountEntity accountEntity) {
    accountRepository.delete(accountEntity);
  }
}
