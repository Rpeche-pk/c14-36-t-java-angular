package com.nocountry.cashier.persistance.entity.listener;

import com.nocountry.cashier.persistance.entity.UserEntity;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.nocountry.cashier.persistance.entity.listener
 * @license Lrpa, zephyr cygnus
 * @since 10/10/2023
 */
@Component
public class UserListener {

    @PrePersist
    public void onCreate(UserEntity user) {
        user.setEnabled(Boolean.TRUE);
    }

}
