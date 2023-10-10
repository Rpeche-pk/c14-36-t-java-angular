package com.nocountry.cashier.services;

import com.nocountry.cashier.persistance.entities.TransactionEntity;
import com.nocountry.cashier.persistance.repositories.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public List<TransactionEntity> getAllTransactionEntities() {
        return transactionRepository.findAll();
    }

    @Override
    public TransactionEntity getTransaction(Long idTrans) {
        TransactionEntity transaction= transactionRepository.findById(idTrans).orElse(null);
        return transaction;
    }

    @Override
    public TransactionEntity createTransaction(TransactionEntity transactionEntity) {
        return transactionRepository.save(transactionEntity);
    }

    @Override
    public void deleteTransaction(TransactionEntity transactionEntity) {
        transactionRepository.delete(transactionEntity);
    }
}
