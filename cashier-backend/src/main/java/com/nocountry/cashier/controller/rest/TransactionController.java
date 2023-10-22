package com.nocountry.cashier.controller.rest;

import com.nocountry.cashier.controller.dto.request.PageableDto;
import com.nocountry.cashier.controller.dto.request.TransactionRequestDTO;
import com.nocountry.cashier.controller.dto.request.UserRequestDTO;
import com.nocountry.cashier.controller.dto.response.GenericResponseDTO;
import com.nocountry.cashier.controller.dto.response.TransactionResponseDTO;
import com.nocountry.cashier.controller.dto.response.UserResponseDTO;
import com.nocountry.cashier.enums.EnumsState;
import com.nocountry.cashier.enums.EnumsTransactions;
import com.nocountry.cashier.exception.RegisterNotFound;
import com.nocountry.cashier.domain.usecase.TransactionService;
import com.nocountry.cashier.persistance.entity.TransactionEntity;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.nocountry.cashier.util.Constant.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_USER + RESOURECE_TRANSACTION)
@RequiredArgsConstructor
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    private TransactionService transactionService;
    //GetALLTransactions
    //http://localhost:8080/v1/api/customers/transactions?page=0&size=4&order=1&field=id
    @GetMapping
    public ResponseEntity<?> getAllTransactions(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                @RequestParam(value = "size", defaultValue = "4") Integer size,
                                                PageableDto pageableDto) {
        pageableDto.setPage(page);
        pageableDto.setSize(size);
        List<TransactionResponseDTO> content = transactionService.getAll(pageableDto).getContent();
        Map<String, Object> response = Map.of("message", "Listado de Transacciones", "data", content);
        return new ResponseEntity<>(response, OK);

    }

//    @PostMapping("/new")
//    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {
//        TransactionResponseDTO transactionResponse = transactionService.create(requestDTO);
//        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/")
//                .path("{id}").buildAndExpand(transactionResponse.id()).toUriString();
//        return ResponseEntity.status(CREATED).body(uri);
//    }
    //NewTransaction
    //http://localhost:8080/v1/api/customers/transactions/new/b4c5d80d-1e38-4b63-bdb2-aa355973c07c
    @PostMapping("/new/{idAccount}")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequestDTO requestDTO, @PathVariable String idAccount){
        TransactionResponseDTO transactionResponse = transactionService.createTransaction(requestDTO,idAccount);
//        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("")
//                .path("{id}").buildAndExpand(transactionResponse.id()).toUriString();
        return ResponseEntity.status(CREATED).body(transactionResponse.toString());
    }
    //SearchById
    //http://localhost:8080/v1/api/customers/transactions/search/58c6f82a-57f0-4b74-ba56-2dfcd6665a54
    @GetMapping("/search/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        return ResponseEntity.ok(new GenericResponseDTO<>(true, "Transaccion Encontrada", transactionService.getById(id).get()));
    }
    //SearchByState
    //http://localhost:8080/v1/api/customers/transactions/search/state?state=DONE
    @GetMapping("/search/state")
    public ResponseEntity<?> getTransactionsByState(@RequestParam String idAccount,
                                                    @RequestParam EnumsState state,
                                                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "4") Integer size,
                                                    PageableDto pageableDto) {
        pageableDto.setPage(page);
        pageableDto.setSize(size);

        try {
            List<TransactionResponseDTO> content = transactionService.findByState(state, idAccount,pageableDto).getContent();
            Map<String, Object> response = Map.of("message", "Listado Por Estado De Transaccion", "data", content);
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }


    }

    //SearchByType
    //http://localhost:8080/v1/api/customers/transactions/search/type?type=DEPOSIT
    @GetMapping("/search/type")
    public ResponseEntity<?> getTransactionsByType(@RequestParam String idAccount,
    @RequestParam EnumsTransactions type,
    @RequestParam(value = "page", defaultValue = "0") Integer page,
    @RequestParam(value = "size", defaultValue = "4") Integer size,
    PageableDto pageableDto) {


        pageableDto.setPage(page);
        pageableDto.setSize(size);

        try {
            List<TransactionResponseDTO> content = transactionService.findByType(type, idAccount,pageableDto).getContent();
            Map<String, Object> response = Map.of("message", "Listado Por Tipo De Transacccion", "data", content);
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }

    }
    //SearchByAmount
    //http://localhost:8080/v1/api/customers/transactions/search/amount?amount=900
    @GetMapping("/search/amount")
    public ResponseEntity<?> getTransactionsByAmount(@RequestParam String idAccount,
                                                     @RequestParam BigDecimal amount,
                                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "size", defaultValue = "4") Integer size,
                                                     PageableDto pageableDto) {

        try {
            List<TransactionResponseDTO> content = transactionService.findByAmount(amount ,idAccount,pageableDto).getContent();
            Map<String, Object> response = Map.of("message", "Listado Por De Transacciones Por Monto", "data", content);
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));

        }

    }
//    public ResponseEntity<?> getTransactionsByType(@RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                @RequestParam(value = "size", defaultValue = "4") Integer size, PageableDto pageableDto,@PathVariable String type) {
//        pageableDto.setPage(page);
//        pageableDto.setSize(size);
//        List<TransactionResponseDTO> content = Collections.singletonList(transactionService.getTrasactionByTypeTransaction(type));
//        Map<String, Object> response = Map.of("message", "Listado de Transacciones por Tipo", "data", content);
//        return new ResponseEntity<>(response, OK);
//    }
//    @GetMapping("/search/date")
//    public ResponseEntity<?> getTransactionsByDate(@RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                @RequestParam(value = "size", defaultValue = "4") Integer size, PageableDto pageableDto,@PathVariable Date date ){
//        pageableDto.setPage(page);
//        pageableDto.setSize(size);
//        List<TransactionResponseDTO> content = Collections.singletonList(transactionService.getTrasactionByDate(date));
//        Map<String, Object> response = Map.of("message", "Listado de Transacciones por Tipo", "data", content);
//        return new ResponseEntity<>(response, OK);
//    }

}
