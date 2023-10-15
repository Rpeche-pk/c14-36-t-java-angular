package com.nocountry.cashier.domain.usecase;

import com.nocountry.cashier.persistance.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    public List<TransactionEntity> getAllTransactionEntities();
    public TransactionEntity getTransaction(Long idTrans);
    public TransactionEntity createTransaction(TransactionEntity transactionEntity);
    public void deleteTransaction(TransactionEntity TransactionEntity);
}
