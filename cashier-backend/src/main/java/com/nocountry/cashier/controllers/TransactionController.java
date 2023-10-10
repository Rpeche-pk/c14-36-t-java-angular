package com.nocountry.cashier.controllers;

import com.nocountry.cashier.exception.RegisterNotFound;
import com.nocountry.cashier.persistance.entities.TransactionEntity;
import com.nocountry.cashier.services.TransactionService;
//import com.nocountry.cashier.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/transaction")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    private TransactionService transactionService;

    //I need the id of user who make transaction?
    //@Autowired
    //private UserService userService;

    @GetMapping
    public List<TransactionEntity> getAllTransactions(){
        List<TransactionEntity> transactionsList = transactionService.getAllTransactionEntities();

        transactionsList.forEach(application -> logger.info(transactionsList.toString()));

        return transactionsList;
    }

    @GetMapping("/{idTrans}")
    public ResponseEntity<TransactionEntity> getApplication(@PathVariable Long idTrans){

        TransactionEntity transaction = transactionService.getTransaction(idTrans);

        if(transaction == null){
            throw new RegisterNotFound("No se encontro la Transaccion ");
        }
        return  ResponseEntity.ok(transaction);
    }

    @PostMapping
    public TransactionEntity createTransaction(@RequestBody TransactionEntity transaction){
        logger.info("Transactions : "+transaction);
        return transactionService.createTransaction(transaction);

    }

    @DeleteMapping("/{idTrans}")
    public ResponseEntity<Map<String,Boolean>> deleteApllication(@PathVariable Long idTrans){

        TransactionEntity transaction= transactionService.getTransaction(idTrans);
        if(transaction == null){
            throw new RegisterNotFound("ID not found " +idTrans);
        }
        transactionService.deleteTransaction(transaction);
        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
