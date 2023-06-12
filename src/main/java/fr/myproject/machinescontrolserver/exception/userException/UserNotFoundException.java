package fr.myproject.machinescontrolserver.exception.userException;

public class UserNotFoundException extends Exception {
    private String message;
    public UserNotFoundException() {}
    public UserNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
