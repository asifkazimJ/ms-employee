package az.kapitalbank.msemployee.error;

public class DuplicateRecordException extends CommonException{
    public DuplicateRecordException(String code, String message) {
        super(code, message);
    }
}
