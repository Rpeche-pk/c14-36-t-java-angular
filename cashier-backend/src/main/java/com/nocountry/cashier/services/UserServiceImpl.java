package com.nocountry.cashier.services;

import com.nocountry.cashier.persistance.entities.UserEntity;
import com.nocountry.cashier.persistance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void deleteUser(UserEntity userEntity){
        userRepository.delete(userEntity);
    }
    @Override
    public UserEntity getUser(Long idUser) {
        UserEntity user = userRepository.findById(idUser).orElse(null);
        return user;
    }
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
