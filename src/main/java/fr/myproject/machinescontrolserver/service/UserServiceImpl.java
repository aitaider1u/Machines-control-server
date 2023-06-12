package fr.myproject.machinescontrolserver.service;


import fr.myproject.machinescontrolserver.model.UserEntity;
import fr.myproject.machinescontrolserver.repository.UserEntityRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;
    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserEntityRepository userEntityRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userEntityRepository = userEntityRepository;
    }


    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setActiveAccount(false);
        return userEntityRepository.save(userEntity);
    }



    public String hashPassword(String password){
        return passwordEncoder.encode(password);
    }
}
