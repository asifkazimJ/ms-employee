package az.kapitalbank.msemployee.error;

public class EmployeeNotFoundException extends CommonException{
    public EmployeeNotFoundException(String code, String message) {
        super(code, message);
    }
}
