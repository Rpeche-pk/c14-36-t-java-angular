package com.nocountry.cashier.persistance.entity;

import com.nocountry.cashier.persistance.entity.listener.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.LuhnCheck;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer")
@SQLDelete(sql = "UPDATE customer SET enabled= FALSE where id=?")
@Where(clause = "enabled=TRUE")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends Auditable<LocalDateTime> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 85)
    private String name;

    @Column(name = "last_name", nullable = false, length = 95)
    private String lastName;

    @Column(nullable = false, unique = true, length = 10)
    private String dni;
    

    @Column(nullable = false, unique = true, length = 15)
    private String phone;

    @Column(unique = true, length = 110)
    private String email;

    private String address;

    @Column(name = "birth_date")
    @Temporal(value = TemporalType.DATE)
    private LocalDate birthDate;

    @Column(unique = true, length = 25)
    private String cvu;

    @Temporal(value = TemporalType.DATE)
    private LocalDateTime openAccountDate;

    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "url_profile")
    private ImageEntity image;

    /*@Column(name = "user_name", nullable = false, unique = true, length = 120)
    private String userName;

    @Column(nullable = false)
    private String password;*/


}
