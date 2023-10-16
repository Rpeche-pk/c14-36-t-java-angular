package com.nocountry.cashier.domain.service;

import com.nocountry.cashier.controller.dto.response.AccountResponseDTO;
import com.nocountry.cashier.domain.usecase.AccountService;

import com.nocountry.cashier.persistance.entity.AccountEntity;
import com.nocountry.cashier.persistance.entity.UserEntity;
import com.nocountry.cashier.persistance.mapper.AccountMapper;
import com.nocountry.cashier.persistance.repository.AccountRepository;
import com.nocountry.cashier.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<AccountResponseDTO> getAllAccounts() {

        return accountMapper.toGetAccountDTOList(accountRepository.findAll());
    }

    @Override
    public AccountEntity getAccount(Long idAccount) {
        AccountEntity account = accountRepository.findById(idAccount).orElse(null);
        return account;
    }

    @Override
    public AccountResponseDTO createAccount(String uuidUser) {

        UserEntity userEntity = userRepository.findById(uuidUser).orElse(null);

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setTotalAccount(0D);
        accountEntity.setOpenAccountDate(LocalDate.now());
        accountEntity.setCvu(generateCvu());
        accountEntity.setStatus(true);

        accountRepository.save(accountEntity);

        //guardar en relacion user
        //userRepository.save(accountEntity);

        return accountMapper.toGetAccountDTO(accountEntity);
    }

    private String generateCvu() {
        Random cvuRandom = new Random();
        Long cvuGenerated = cvuRandom.nextLong(400555123, 999999999);
        return cvuGenerated.toString();
    }

    /*@Override
    public AccountEntity createAccount(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }*/


    @Override
    public void deleteAccount(AccountEntity accountEntity) {
        accountRepository.delete(accountEntity);
    }
}
