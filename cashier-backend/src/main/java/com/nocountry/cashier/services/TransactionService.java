package com.nocountry.cashier.services;

import com.nocountry.cashier.persistance.entities.TransactionEntity;

import java.util.List;

public interface TransactionService {
    public List<TransactionEntity> getAllTransactionEntities();
    public TransactionEntity getTransaction(Long idTrans);
    public TransactionEntity createTransaction(TransactionEntity transactionEntity);
    public void deleteTransaction(TransactionEntity TransactionEntity);
}
