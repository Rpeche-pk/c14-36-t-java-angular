package com.nocountry.cashier.persistance.entity;

import com.nocountry.cashier.enums.EnumsState;
import com.nocountry.cashier.enums.EnumsTransactions;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTran;
    @CreatedDate
    private Date dateEmit;
    @Enumerated(EnumType.STRING)
    //INCOME,EGRESS,TRANSFER,DEPOSIT,PAYMENT_QR
    private EnumsTransactions typeTrans;
    private Long origin;
    private Long destination;
    //STATE WITH enums OR boolean?
    //private Boolean state;
    @Enumerated(EnumType.STRING)
    private EnumsState state;



}
