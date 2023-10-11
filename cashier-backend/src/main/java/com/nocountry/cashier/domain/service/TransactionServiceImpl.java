package com.nocountry.cashier.domain.service;

import com.nocountry.cashier.domain.usecase.TransactionService;
import com.nocountry.cashier.persistance.entity.TransactionEntity;
import com.nocountry.cashier.persistance.repository.TransactionRepository;
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
