package com.nocountry.cashier.persistance.repositories;

import com.nocountry.cashier.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
