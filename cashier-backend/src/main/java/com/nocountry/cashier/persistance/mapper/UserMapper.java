package com.nocountry.cashier.persistance.mapper;

import com.nocountry.cashier.controller.dto.response.UserResponseDTO;
import com.nocountry.cashier.persistance.entity.UserEntity;
import com.nocountry.cashier.controller.dto.request.UserRequestDTO;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ImageMapper.class})
public interface UserMapper {

    @Mapping(target = "openAccountDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "cvu", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    UserEntity toUserEntity(UserRequestDTO userRequestDTO);

    @Mapping(target ="image" , source ="image.imageUrl")
    UserResponseDTO toUserResponseDto(UserEntity userEntity);

}