package com.nocountry.cashier.controllers;

import com.nocountry.cashier.exception.RegisterNotFound;
import com.nocountry.cashier.persistance.entities.UserEntity;
import com.nocountry.cashier.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){

        List<UserEntity> userList= userService.getAllUsers();

        userList.forEach(application -> logger.info(userList.toString()));

        return userList;
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserEntity> getApplication(@PathVariable long idUser){

        UserEntity user = userService.getUser(idUser);

        if(user == null){
            throw new RegisterNotFound("No se encontro el empleado id: " +idUser);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        logger.info("User to create: " +user);
        return userService.createUser(user);

    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Map<String, Boolean>>
    deleteApplication(@PathVariable Long idUser){
        UserEntity user = userService.getUser(idUser);

        if(user == null){
            throw new RegisterNotFound("ID not found " +idUser);
        }
        userService.deleteUser(user);
        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
