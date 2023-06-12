package fr.myproject.machinescontrolserver.exception.userException;

public class UserAlreadyExistException  extends Exception{
    private String message;
    public UserAlreadyExistException() {}
    public UserAlreadyExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
