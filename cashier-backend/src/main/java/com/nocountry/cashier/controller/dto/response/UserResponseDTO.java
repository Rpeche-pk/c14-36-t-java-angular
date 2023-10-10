package com.nocountry.cashier.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.nocountry.cashier.controller.dto.response
 * @license Lrpa, zephyr cygnus
 * @since 10/10/2023
 */
@JsonPropertyOrder({"name", "lastName", "image", "cvu", "createdDate"})
@JsonRootName(value = "User")
public record UserResponseDTO(
        LocalDateTime createdDate,
        String name,
        String lastName,
        String cvu,
        ImageResponseDTO image

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}

