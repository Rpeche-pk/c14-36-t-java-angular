package com.nocountry.cashier.persistance.mapper;

import com.nocountry.cashier.controller.dto.response.UserResponseDTO;
import com.nocountry.cashier.persistance.entity.UserEntity;
import com.nocountry.cashier.controller.dto.request.UserRequestDTO;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ImageMapper.class})
public interface UserMapper {

    @Mapping(target = "openAccountDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "cvu", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "birthDate", source = "birthDate",qualifiedByName = "stringToLocalDate")
    UserEntity toUserEntity(UserRequestDTO userRequestDTO);

    @Mapping(target = "id", source = "id")
    UserResponseDTO toUserResponseDto(UserEntity userEntity);

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String birthDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(birthDate.strip(),formatter);
    }

}