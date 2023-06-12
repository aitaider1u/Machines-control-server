package fr.myproject.machinescontrolserver.exception.roleException;

import fr.myproject.machinescontrolserver.dto.ExceptionResponseDto;
import fr.myproject.machinescontrolserver.model.Role;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
public class RoleExistYetException extends Exception {
    private String message;
    public RoleExistYetException() {}
    public RoleExistYetException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
