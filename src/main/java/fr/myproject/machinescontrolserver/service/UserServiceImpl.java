package fr.myproject.machinescontrolserver.service;


import fr.myproject.machinescontrolserver.exception.userException.UserNotFoundException;
import fr.myproject.machinescontrolserver.model.UserEntity;
import fr.myproject.machinescontrolserver.repository.RoleRepository;
import fr.myproject.machinescontrolserver.repository.UserEntityRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserEntityRepository userEntityRepository,
                           RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userEntityRepository = userEntityRepository;
        this.roleRepository = roleRepository;

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

    @Override
    public UserEntity activationAccount(long id) throws UserNotFoundException{
        if (!userEntityRepository.existsById(id))
            throw new UserNotFoundException("User with the id : "+ id +" does not existe");

        UserEntity user = this.userEntityRepository.findById(id);
        if (user.isActiveAccount())
            return user;
        user.setActiveAccount(!user.isActiveAccount());
        user.addRole(this.roleRepository.findByCode("user"));
        return this.userEntityRepository.save(user);
    }

    public UserEntity blockUnblockAnAccount(long id) throws UserNotFoundException{
        if (!userEntityRepository.existsById(id))
            throw new UserNotFoundException("User with the id : "+ id +" does not existe");
        UserEntity user = this.userEntityRepository.findById(id);
        user.setActiveAccount(!user.isActiveAccount());
        return this.userEntityRepository.save(user);
    }

}
