package com.nocountry.cashier.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nocountry.cashier.persistance.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link UserEntity}
 */
public record UserRequestDTO(
        @Pattern(regexp = "^[a-zA-ZÑñ ]+$", message = "No se permite carácteres especiales y números.")
        @NotBlank(message = "Este campo no debe consistir solo en espacios en blanco")
        @NotEmpty(message = "Este campo no puede estar vacío. Ingrese su nombre")
        String name,

        @Pattern(regexp = "^[a-zA-ZñÑ ]+$", message = "No se permite carácteres especiales y números.")
        @NotBlank(message = "no debe consistir solo en espacios en blanco")
        @NotEmpty(message = "no puede estar vacío. Ingrese sus apellidos")
        String lastName,

        @NotEmpty(message = "Debe ingresar un número de dni")
        String dni,
        @Pattern(regexp = "^[0-9]{9}$", message = "El número de celular debe tener 9 dígitos")
        @NotEmpty(message = "Debe ingresar un número de celular")
        String phone,
        @NotEmpty(message = "es requerido.")
        @NotBlank(message = "no debe consistir solo en espacios en blanco")
        @Pattern(regexp = "^[a-z0-9ñÑ]+(?!.*(?:\\+{2,}|\\-{2,}|\\.{2,}))(?:[\\.+\\-_]{0,1}[a-z0-9Ññ])*@gmail\\.com$", message = "Debe ser un correo tipo gmail.")
        String email,
        String address,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}