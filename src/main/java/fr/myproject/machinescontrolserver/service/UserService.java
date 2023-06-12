package fr.myproject.machinescontrolserver.service;

import fr.myproject.machinescontrolserver.exception.userException.UserNotFoundException;
import fr.myproject.machinescontrolserver.model.UserEntity;

import java.util.List;

public interface UserService{

    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity userEntity);
    String hashPassword(String password);
    UserEntity activationAccount(long id) throws UserNotFoundException;
    UserEntity blockUnblockAnAccount(long id) throws UserNotFoundException;
}
