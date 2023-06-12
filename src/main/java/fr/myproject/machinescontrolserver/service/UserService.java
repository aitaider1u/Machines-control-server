package fr.myproject.machinescontrolserver.service;

import fr.myproject.machinescontrolserver.model.UserEntity;

import java.util.List;

public interface UserService{

    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity userEntity);
    String hashPassword(String password);

}
