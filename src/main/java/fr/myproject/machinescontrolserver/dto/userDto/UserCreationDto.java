package fr.myproject.machinescontrolserver.dto.userDto;

import lombok.Data;

@Data
public class UserCreationDto {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
}
