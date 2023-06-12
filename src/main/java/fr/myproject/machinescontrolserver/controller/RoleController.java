package fr.myproject.machinescontrolserver.controller;

import fr.myproject.machinescontrolserver.dto.RoleDto;
import fr.myproject.machinescontrolserver.exception.roleException.RoleDoesNotExistException;
import fr.myproject.machinescontrolserver.exception.roleException.RoleExistYetException;
import fr.myproject.machinescontrolserver.model.Role;
import fr.myproject.machinescontrolserver.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    public RoleController(RoleService roleService,ModelMapper modelMapper) {
        super();
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        return  ResponseEntity.ok().body(roleService.getAllRoles().stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) throws RoleExistYetException {
        // convert DTO to entity
        Role roleRequest = modelMapper.map(roleDto, Role.class);
        Role role = roleService.createRole(roleRequest);
        // convert entity to DTO
        RoleDto roleResponse = modelMapper.map(role, RoleDto.class);
        return ResponseEntity.ok().body(roleResponse);
    }


    @RequestMapping(method = RequestMethod.PUT , value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> updateRole(@PathVariable long id, @RequestBody RoleDto roleDto) throws RoleDoesNotExistException {
        // convert DTO to entity
        Role roleRequest = modelMapper.map(roleDto, Role.class);
        Role role = roleService.updateRole(id,roleRequest);
        // convert entity to DTO
        RoleDto roleResponse = modelMapper.map(role, RoleDto.class);
        return ResponseEntity.ok().body(roleResponse );
    }
}
