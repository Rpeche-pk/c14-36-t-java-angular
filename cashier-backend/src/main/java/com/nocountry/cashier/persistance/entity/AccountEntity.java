package com.nocountry.cashier.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    @Column(unique = true, length = 25)
    private String cvu;

    private LocalDate openAccountDate;

    private LocalDate updateAccountDate;

    private Double TotalAccount;

    private boolean status;



}
