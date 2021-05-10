package az.kapitalbank.msemployee.error;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String USER_NOT_FOUND = "USER_NOT_FOUND";
    String INVALID_HEADER = "INVALID_TOKEN";
    String INVALID_LOGIN_DETAILS = "INVALID_LOGIN_DETAILS";
    String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    String EMPLOYEE_NOT_FOUND = "EMPLOYEE_NOT_FOUND";
    String DUPLICATE_RECORD = "DUPLICATE_RECORD";
    String INVALID_REQUEST = "INVALID_REQUEST";

}
