package pro.skystudent.streamandoptional.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException(String message) {
        super(message);
    }

    public EmployeeAlreadyExistException() {
    }
}
