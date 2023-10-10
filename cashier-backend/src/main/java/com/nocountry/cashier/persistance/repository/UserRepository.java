package com.nocountry.cashier.persistance.repository;
import com.nocountry.cashier.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByPhone(String phone);
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<UserEntity> findByDni(String dni);


}
