package com.nocountry.cashier.controller.rest;

import com.nocountry.cashier.domain.usecase.AccountService;
import com.nocountry.cashier.exception.RegisterNotFound;

import com.nocountry.cashier.persistance.entity.AccountEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountEntity> getAllAccount(){

        List<AccountEntity> accountList= accountService.getAllAccounts();

        accountList.forEach(application -> logger.info(accountList.toString()));

        return accountList;
    }

    @GetMapping("/{idAccount}")
    public ResponseEntity<AccountEntity> getAccount(@PathVariable long idAccount){

        AccountEntity account = accountService.getAccount(idAccount);

        if(account == null){
            throw new RegisterNotFound("Doesn´t Found account id: " +idAccount);
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public AccountEntity createAccount(@RequestBody AccountEntity account){
        logger.info("Account to create: " +account);
        return accountService.createAccount(account);

    }

    @DeleteMapping("/{idAccount}")
    public ResponseEntity<Map<String, Boolean>>
    deleteAccount(@PathVariable Long idAccount){
        AccountEntity account = accountService.getAccount(idAccount);

        if(account == null){
            throw new RegisterNotFound("ID not found " +idAccount);
        }
        accountService.deleteAccount(account);
        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
