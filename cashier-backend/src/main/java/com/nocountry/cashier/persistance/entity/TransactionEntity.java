package com.nocountry.cashier.persistance.entity;

import com.nocountry.cashier.enums.EnumsState;
import com.nocountry.cashier.enums.EnumsTransactions;
import com.nocountry.cashier.persistance.entity.listener.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionEntity extends Auditable<LocalDateTime> {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    private String id;
    @Column(name = "date_emit")
    private LocalDateTime dateEmit;
    @Enumerated(EnumType.STRING)
    //INCOME,EGRESS,TRANSFER,DEPOSIT,PAYMENT_QR
    @Column(name = "type_trans")
    private EnumsTransactions type;
    @Column(name="amount")
    private Long  amount;
    @Column(name = "origin")
    private Long origin;
    @Column(name = "destination")
    private Long destination;
    //STATE WITH enums OR boolean?
    //private Boolean state;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private EnumsState state;



}
