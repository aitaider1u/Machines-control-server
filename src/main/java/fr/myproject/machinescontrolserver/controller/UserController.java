package fr.myproject.machinescontrolserver.controller;

import fr.myproject.machinescontrolserver.dto.deviceDto.DeviceDto;
import fr.myproject.machinescontrolserver.dto.userDto.UserCreationDto;
import fr.myproject.machinescontrolserver.dto.userDto.UserDto;
import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.model.Role;
import fr.myproject.machinescontrolserver.model.UserEntity;
import fr.myproject.machinescontrolserver.service.DeviceService;
import fr.myproject.machinescontrolserver.service.UserService;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController{

    private final ModelMapper modelMapper;
    private final UserService userService;


    public UserController(UserService userService,
                          ModelMapper modelMapper) {
        super();
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>>  getAllUsers(){
        return  ResponseEntity.ok().body(userService.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreationDto userCreationDto) {
        // convert DTO to entity
        userCreationDto.setPassword(this.userService.hashPassword(userCreationDto.getPassword()));
        UserEntity userRequest = modelMapper.map(userCreationDto, UserEntity.class);
        System.out.println(userRequest);
        //save the user
        UserEntity userEntity  =  this.userService.createUser(userRequest);
        // convert entity to DTO
        UserDto userResponse = modelMapper.map(userEntity, UserDto.class);
        return ResponseEntity.ok().body(userResponse);
    }

}
