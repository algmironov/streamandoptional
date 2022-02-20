package pro.skystudent.streamandoptional.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOrMissingNameException extends RuntimeException {
    public InvalidOrMissingNameException(String message) {
        super(message);
    }
}
