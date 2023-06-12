package fr.myproject.machinescontrolserver.controllerAdvice;

import fr.myproject.machinescontrolserver.dto.ExceptionResponseDto;
import fr.myproject.machinescontrolserver.exception.roleException.RoleDoesNotExistException;
import fr.myproject.machinescontrolserver.exception.roleException.RoleExistYetException;
import fr.myproject.machinescontrolserver.exception.userException.UserAlreadyExistException;
import fr.myproject.machinescontrolserver.exception.userException.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(RoleExistYetException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody ExceptionResponseDto handleRoleExistsYet(final RoleExistYetException exception, final HttpServletRequest request) {
        return new ExceptionResponseDto(exception.getMessage(),request.getRequestURI());
    }

    @ExceptionHandler(RoleDoesNotExistException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody ExceptionResponseDto handleRoleNotExists(final RoleDoesNotExistException exception, final HttpServletRequest request) {
        return new ExceptionResponseDto(exception.getMessage(),request.getRequestURI());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody ExceptionResponseDto handleUserAlreadyExist(final UserAlreadyExistException exception, final HttpServletRequest request) {
        return new ExceptionResponseDto(exception.getMessage(),request.getRequestURI());
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody ExceptionResponseDto handleUserNotFound(final UserNotFoundException exception, final HttpServletRequest request) {
        return new ExceptionResponseDto(exception.getMessage(),request.getRequestURI());
    }
}
