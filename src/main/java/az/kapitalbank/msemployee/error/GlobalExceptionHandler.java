package az.kapitalbank.msemployee.error;


import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
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

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ErrorResponse> handlerDuplicateRecordException(DuplicateRecordException ex) {
        ErrorResponse response = new ErrorResponse(ex.getCode(),ex.getMessage());
        log.error("DuplicateRecordException , error:{}, devMessage:{}", response, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> processExpiredJwtException(ExpiredJwtException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_TOKEN,ex.getMessage());
        log.error("ExpiredJwtException , error:{}, devMessage:{}", response, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerErrors(Exception ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, "Something went wrong");
        log.error("Error unexpected internal server, responseBody:{},exception:{}", response, ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ErrorCode.METHOD_NOT_SUPPORTED, ex.getMessage());
        log.error("Method not supported,exception:{}", ex.getMessage());
        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.VALIDATION_ERROR, ex.getMessage());
        log.info("Http message not readable error:{},response:{}", ex.getMessage(), errorResponse);
        return new ResponseEntity<>(errorResponse, headers, status);
    }
}
