package com.nocountry.cashier.domain.service;

import com.nocountry.cashier.domain.usecase.AccountService;

import com.nocountry.cashier.persistance.entity.AccountEntity;
import com.nocountry.cashier.persistance.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity getAccount(Long idAccount) {
        AccountEntity account = accountRepository.findById(idAccount).orElse(null);
        return account;
    }

    @Override
    public AccountEntity createAccount(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    @Override
    public void deleteAccount(AccountEntity accountEntity) {
        accountRepository.delete(accountEntity);
    }
}
