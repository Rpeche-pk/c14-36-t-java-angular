package com.nocountry.cashier.services;

import com.nocountry.cashier.persistance.entities.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserEntity> getAllUsers();
    public UserEntity getUser(Long idUser);
    public UserEntity createUser(UserEntity userEntity);
    public void deleteUser(UserEntity userEntity);
}
