package fr.myproject.machinescontrolserver.controller;

import fr.myproject.machinescontrolserver.dto.deviceDto.DeviceDto;
import fr.myproject.machinescontrolserver.dto.userDto.UserCreationDto;
import fr.myproject.machinescontrolserver.dto.userDto.UserDto;
import fr.myproject.machinescontrolserver.exception.userException.UserNotFoundException;
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
        //save the user
        UserEntity userEntity  =  this.userService.createUser(modelMapper.map(userCreationDto, UserEntity.class));
        // convert entity to DTO
        return ResponseEntity.ok().body(modelMapper.map(userEntity, UserDto.class));
    }


    @RequestMapping(value = "/activation/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<UserDto> activationAccount(@PathVariable String id) throws UserNotFoundException {

        return ResponseEntity.ok().body(
                modelMapper.map(this.userService.activationAccount(Long.parseLong(id)),
                UserDto.class) );
    }

    @RequestMapping(value = "/blockUnblock/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<UserDto> blockUnblockAnAccount(@PathVariable String id) throws UserNotFoundException {
        return ResponseEntity.ok().body(
                modelMapper.map(this.userService.blockUnblockAnAccount(Long.parseLong(id)),
                        UserDto.class) );
    }
}
