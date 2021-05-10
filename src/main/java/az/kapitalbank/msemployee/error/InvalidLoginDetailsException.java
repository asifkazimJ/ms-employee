package az.kapitalbank.msemployee.error;

public class InvalidLoginDetailsException extends CommonException{
    public InvalidLoginDetailsException(String code, String message) {
        super(code, message);
    }
}
