package pro.skystudent.streamandoptional.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NoFreeSpotsAvaliableException extends RuntimeException{
    public NoFreeSpotsAvaliableException(String message) {
        super(message);
    }

    public NoFreeSpotsAvaliableException() {
    }
}
