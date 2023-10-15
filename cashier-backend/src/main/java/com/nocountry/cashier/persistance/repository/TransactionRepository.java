package com.nocountry.cashier.persistance.repository;

import com.nocountry.cashier.persistance.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
}
