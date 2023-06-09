package fr.myproject.machinescontrolserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT) // 409
public class DeviceDoesNotExistException   extends RuntimeException {
    public DeviceDoesNotExistException(long deviceId){
        super("Device " + deviceId + " does not exist.");
    }

}
