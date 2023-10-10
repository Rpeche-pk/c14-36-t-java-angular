package com.nocountry.cashier.domain.usecase;


import com.nocountry.cashier.controller.dto.request.PageableDto;
import com.nocountry.cashier.controller.dto.request.UserRequestDTO;
import com.nocountry.cashier.controller.dto.response.UserResponseDTO;
import com.nocountry.cashier.domain.generic.ApiCrudGeneric;

import java.util.UUID;

public interface UserService extends ApiCrudGeneric<UserRequestDTO, UserResponseDTO, PageableDto, UUID>{
}
