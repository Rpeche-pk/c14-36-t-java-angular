package com.nocountry.cashier.domain.service;

import com.nocountry.cashier.controller.dto.request.PageableDto;
import com.nocountry.cashier.controller.dto.request.UserRequestDTO;
import com.nocountry.cashier.controller.dto.response.UserResponseDTO;
import com.nocountry.cashier.domain.usecase.UserService;
import com.nocountry.cashier.exception.DuplicateEntityException;
import com.nocountry.cashier.persistance.entity.UserEntity;
import com.nocountry.cashier.persistance.mapper.UserMapper;
import com.nocountry.cashier.persistance.repository.UserRepository;
import com.nocountry.cashier.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final Utility utility;

    @Override
    public UserResponseDTO create(UserRequestDTO data) {
        UserEntity userSave;
        UserEntity filtro= userRepository.findByDni (data.dni().strip()).orElse(null);
        UserEntity filtro2= userRepository.findByEmailIgnoreCase(data.email().strip()).orElse(null);
        if (!Objects.isNull(filtro) || !Objects.isNull(filtro2)) throw new DuplicateEntityException("Oops el cliente ya existe");

        clienteSave = Optional.of(newCustomer)
                .map(clienteMapper::toClienteEntity)
                .map(clienteRepository::save)
                .orElseThrow(() -> new GenericException("Oops ocurrió un error. Celular o email ya existe!!", HttpStatus.BAD_REQUEST));

        ClienteResponseDto clienteResponseDto = clienteMapper.toClienteResponseDto(clienteSave);
        Map<String, Object> response = Map.of("message", "Usuario creado con éxito!!", "cliente", clienteResponseDto);
        return (ResponseEntity<ClienteResponseDto>) ResponseUtils.getResponseEntity(response,HttpStatus.CREATED);
    }

    @Override
    public Page<UserResponseDTO> getAll(PageableDto pageableDto) {
        Pageable pageable = utility.setPageable(pageableDto);
        Page<UserEntity> products = userRepository.findAll(pageable);
        Predicate<UserEntity> predicate = UserEntity::getEnabled;
        List<UserResponseDTO> responseDtoList = products.getContent().stream()
                .filter(predicate)
                .map(mapper::toUserResponseDto)
                .toList();
        return new PageImpl<>(responseDtoList);
    }

    @Override
    public Optional<UserResponseDTO> getById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public UserResponseDTO update(UUID uuid, UserRequestDTO data) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}
