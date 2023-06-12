package fr.myproject.machinescontrolserver.dto.userDto;

import fr.myproject.machinescontrolserver.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private boolean activeAccount;
    List<Role> userRoles = new ArrayList<>();
}
