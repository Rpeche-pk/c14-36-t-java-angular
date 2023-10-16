package com.nocountry.cashier.persistance.entity;


import jakarta.persistence.*;

import com.nocountry.cashier.persistance.entity.listener.audit.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.time.LocalDate;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class AccountEntity extends Auditable<LocalDateTime> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idAccount;

    @Column(unique = true, length = 25)
    private String cvu;

    private LocalDate openAccountDate;

    private LocalDate updateAccountDate;

    private Double TotalAccount;


    private boolean status;



}
