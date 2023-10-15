package com.nocountry.cashier.domain.usecase;


import com.nocountry.cashier.persistance.entity.AccountEntity;

import java.util.List;

public interface AccountService {

    List<AccountEntity> getAllAccounts();

    AccountEntity getAccount(Long idAccount);

    AccountEntity createAccount(AccountEntity accountEntity);

    void deleteAccount(AccountEntity accountEntity);
}
