package com.nocountry.cashier.persistance.repositories;

import com.nocountry.cashier.persistance.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
}
