package com.nocountry.cashier.persistance.repository;

import com.nocountry.cashier.persistance.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,String> {

  //List<TransactionEntity> findByStateIs(String state);
  //List<TransactionEntity> findByStateEquals(String state);
  //List<TransactionEntity> findByTypeIs(String state);
  //List<TransactionEntity> findByAmountLessThanEqual(String state);
//    @Query(value = "SELECT t FROM TransactionEntity t WHERE  t.state = :state")
//    List<TransactionEntity> findByStateContaining(@Param("state") String state);

//  @Query(value = "SELECT t FROM TransactionEntity t WHERE t.state LIKE %:state%")
//  List<TransactionEntity> findByStateContaining(@Param("state") String state);

  List<TransactionEntity> findByStateContaining(String state);



}
