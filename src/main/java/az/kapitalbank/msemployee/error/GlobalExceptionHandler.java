package az.kapitalbank.msemployee.error;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidLoginDetailsException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidLoginDetailsException(InvalidLoginDetailsException ex) {
        ErrorResponse response = new ErrorResponse(ex.getCode(),ex.getMessage());
        log.error("InvalidLoginDetailsException , error:{}, devMessage:{}", response, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ex.getCode(),ex.getMessage());
        log.error("EmployeeNotFoundException , error:{}, devMessage:{}", response, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
