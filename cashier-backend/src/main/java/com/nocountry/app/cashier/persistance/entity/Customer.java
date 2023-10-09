package com.nocountry.app.cashier.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author ROMULO
 * @package com.nocountry.app.cashier.persistance.entity.listener
 * @license Lrpa, zephyr cygnus
 * @since 8/10/2023
 */
@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 85)
    private String name;

    @Column(name = "last_name", nullable = false, length = 95)
    private String lastName;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(nullable = false, unique = true, length = 10)
    private String dni;

    @Column(nullable = false, unique = true, length = 15)
    private String phone;

    @Column(unique = true, length = 110)
    private String email;

    private String address;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private Boolean enabled;

    @Column(name = "user_name", nullable = false, unique = true, length = 120)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(name = "url_profile")
    private String urlProfile;

    @Column(unique = true, length = 25)
    private String cvu;

}
