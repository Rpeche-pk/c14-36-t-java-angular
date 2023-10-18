package com.nocountry.cashier.domain.usecase;

import com.nocountry.cashier.controller.dto.request.PageableDto;
import com.nocountry.cashier.controller.dto.request.TransactionRequestDTO;
import com.nocountry.cashier.controller.dto.response.TransactionResponseDTO;
import com.nocountry.cashier.domain.generic.ApiCrudGeneric;
import com.nocountry.cashier.enums.EnumsState;
import com.nocountry.cashier.persistance.entity.TransactionEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TransactionService extends ApiCrudGeneric<TransactionRequestDTO, TransactionResponseDTO, PageableDto,String> {

  List<TransactionEntity> findByState(EnumsState state) throws Exception;
  @Override
  TransactionResponseDTO create(TransactionRequestDTO data);

  @Override
  Page<TransactionResponseDTO> getAll(PageableDto pageable);

  @Override
  Optional<TransactionResponseDTO> getById(String s);

  @Override
  TransactionResponseDTO update(String s, TransactionRequestDTO data);

  void delete(TransactionEntity transactionEntity);
}
