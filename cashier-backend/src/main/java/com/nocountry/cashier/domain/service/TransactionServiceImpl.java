package com.nocountry.cashier.domain.service;

import com.nocountry.cashier.controller.dto.request.PageableDto;
import com.nocountry.cashier.controller.dto.request.TransactionRequestDTO;
import com.nocountry.cashier.controller.dto.response.AccountResponseDTO;
import com.nocountry.cashier.controller.dto.response.TransactionResponseDTO;
import com.nocountry.cashier.domain.usecase.TransactionService;
import com.nocountry.cashier.enums.EnumsState;
import com.nocountry.cashier.enums.EnumsTransactions;
import com.nocountry.cashier.exception.GenericException;
import com.nocountry.cashier.exception.ResourceNotFoundException;
import com.nocountry.cashier.persistance.entity.AccountEntity;
import com.nocountry.cashier.persistance.entity.TransactionEntity;
import com.nocountry.cashier.persistance.mapper.AccountMapper;
import com.nocountry.cashier.persistance.mapper.TransactionMapper;
import com.nocountry.cashier.persistance.repository.AccountRepository;
import com.nocountry.cashier.persistance.repository.TransactionRepository;
import com.nocountry.cashier.util.Utility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nocountry.cashier.util.GeneratorCVU;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;
    private final AccountMapper accountMapper;
    private final Utility utility;
    @Autowired
    private AccountRepository accountRepository;



    @Override
    public TransactionResponseDTO create(TransactionRequestDTO data){

        TransactionEntity transactionSave = new TransactionEntity();

        data.setDateEmit(LocalDateTime.now().toString());
        data.setState("DONE");
        data.setType("PAYMENT_QR");

        transactionSave = Optional.of(data)
                .map(mapper :: toTransactionEntity )
                .map(transactionRepository::save)
                .orElseThrow(()-> new GenericException("Oops no pudismos resolver la transaccion", HttpStatus.BAD_REQUEST));
        return mapper.toTransactionResponseDto(transactionSave);
    }
    @Transactional
    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO data, String data2) {
        TransactionEntity transaction = new TransactionEntity();
        Optional<AccountEntity> entity = accountRepository.findById(data2);

        data.setOrigin(entity.get().getCvu().toString());
        data.setDestination((GeneratorCVU.generate("202",22)));
        data.setDateEmit(LocalDateTime.now().toString());
        if (entity.isPresent()) {
            transaction = Optional.of(data)
                    .map(mapper::toTransactionEntity)
                    .map(transactionRepository::save)
                    .orElseThrow(() -> new GenericException("Oops no pudismos resolver la transaccion", HttpStatus.BAD_REQUEST));
            transaction.setAccountEntity(entity.get());
            return mapper.toTransactionResponseDto(transaction);
        }else{

            transaction.setAccountEntity(entity.get());
            return mapper.toTransactionResponseDto(transaction);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionResponseDTO> getAll(PageableDto pageableDto) {
        Pageable pageable= utility.setPageable(pageableDto);
        Page<TransactionEntity> transactions = transactionRepository.findAll(pageable);

        List<TransactionResponseDTO> responseDtoList = transactions.getContent().
                stream().
                map(mapper::toTransactionResponseDto).
                toList();
        return new PageImpl<>(responseDtoList);
    }




    @Override
    @Transactional(readOnly = true)
    public Optional<TransactionResponseDTO> getById(String s) {
        Function<String, Optional<TransactionEntity>> function = transactionRepository::findById;
        TransactionEntity transactionEntity = function.apply(s).orElseThrow(() -> new ResourceNotFoundException("Transaccion no encontrada", "id", s));
        return Optional.of(mapper.toTransactionResponseDto(transactionEntity));
    }


//    @Override
//    @Transactional(readOnly = true)
//    public List<TransactionEntity> findByState(EnumsState state,String idAccount) throws Exception{
//        try {
//            List<TransactionEntity> listEntity = transactionRepository.findByState(state,idAccount);
//            return listEntity;
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
//    }

//    @Override
//    public Page<TransactionResponseDTO> findByState(PageableDto pageableDto, EnumsState state, String idAccount) throws Exception {
//        Pageable pageable = utility.setPageable(pageableDto);
//        List<TransactionEntity> transactions = transactionRepository.findByState(state,idAccount);
//        Page<List<TransactionEntity>> transactionEntityPage= transactions.pagable();
//        List<TransactionEntity> responseDtoList = transactions.getContent().Strem()
//                .map(mapper::toTransactionResponseDto)
//                .toList();
//        return new PageImpl<>(responseDtoList);
//    }
@Override
public Page<TransactionResponseDTO> findByState(EnumsState state, String idAccount,PageableDto pageableDto) throws Exception {


    try{
        Pageable pageable = utility.setPageable(pageableDto);
        Page<TransactionEntity> transactionPage = transactionRepository.findByState(state, idAccount, pageable);

        // Mapear la lista de entidades a DTOs
        List<TransactionResponseDTO> responseDtoList = transactionPage.getContent().stream()
                .map(mapper::toTransactionResponseDto)
                .collect(Collectors.toList());

        return new PageImpl<>(responseDtoList, pageable, transactionPage.getTotalElements());
    }catch (Exception e){
        throw new Exception(e.getMessage());
    }
}
    @Override
    @Transactional(readOnly = true)
    public Page<TransactionResponseDTO> findByType(EnumsTransactions type, String idAccount, PageableDto pageableDto) throws Exception{
        try {
            Pageable pageable = utility.setPageable(pageableDto);
            Page<TransactionEntity> transactionPage = transactionRepository.findByType(type, idAccount, pageable);

            // Mapear la lista de entidades a DTOs
            List<TransactionResponseDTO> responseDtoList = transactionPage.getContent().stream()
                    .map(mapper::toTransactionResponseDto)
                    .collect(Collectors.toList());

            return new PageImpl<>(responseDtoList, pageable, transactionPage.getTotalElements());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    } @Override
    @Transactional(readOnly = true)
    public Page<TransactionResponseDTO> findByAmount(BigDecimal amount, String idAccount, PageableDto pageableDto) throws Exception{
        try {
            Pageable pageable = utility.setPageable(pageableDto);
            Page<TransactionEntity> transactionPage = transactionRepository.findByAmount(amount, idAccount, pageable);

            // Mapear la lista de entidades a DTOs
            List<TransactionResponseDTO> responseDtoList = transactionPage.getContent().stream()
                    .map(mapper::toTransactionResponseDto)
                    .collect(Collectors.toList());

            return new PageImpl<>(responseDtoList, pageable, transactionPage.getTotalElements());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
//    @Override
//    @Transactional(readOnly = true)
//    public List<TransactionEntity> findByAmount(BigDecimal amount) throws Exception{
//        try {
//            List<TransactionEntity> listEntity = transactionRepository.findByType(amount);
//            return listEntity;
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
//    }

//    @Transactional(readOnly = true)
//    public Page<TransactionResponseDTO> getTransactionByType(PageableDto pageableDto,String type){
//        Pageable pageable = utility.setPageable(pageableDto);
//        Page<TransactionEntity> transactions = transactionRepository.findAll(pageable);
//        List<TransactionResponseDTO> responseDtoList = transactions.getContent().
//                stream().filter(x->x.equals(type.toUpperCase())).
//                map(mapper::toTransactionResponseDto).toList();
//        return new PageImpl<>(responseDtoList);
//    }
//    @Transactional(readOnly = true)
//    public Page<TransactionResponseDTO> getTransactionByState(PageableDto pageableDto,String state){
//        Pageable pageable = utility.setPageable(pageableDto);
//        Page<TransactionEntity> transactions = transactionRepository.findAll(pageable);
//        List<TransactionResponseDTO> responseDtoList = transactions.getContent().
//                stream().filter(x->x.equals(state.toUpperCase())).
//                map(mapper::toTransactionResponseDto).toList();
//        return new PageImpl<>(responseDtoList);
//    }
//    @Transactional(readOnly = true)
//    public Page<TransactionResponseDTO> getTransactionByDate(PageableDto pageableDto,Date date){
//        Pageable pageable = utility.setPageable(pageableDto);
//        Page<TransactionEntity> transactions = transactionRepository.findAll(pageable);
//        //Predicate<TransactionEntity> predicate = transactions.forEach(transactionEntity -> transactionEntity.getDateEmit())==date;
//        List<TransactionResponseDTO> responseDtoList = transactions.getContent().
//                stream().filter(x-> {
//                    return x.getDateEmit() == date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                }).
//                map(mapper::toTransactionResponseDto).toList();
//        return new PageImpl<>(responseDtoList);
//    }


    @Override
    public TransactionResponseDTO update(String s, TransactionRequestDTO data) {
        return null;
    }

    @Override
    public void delete(TransactionEntity transactionEntity) {

    }

    @Override
    public boolean delete(String s) {
        return false;
    }




}
