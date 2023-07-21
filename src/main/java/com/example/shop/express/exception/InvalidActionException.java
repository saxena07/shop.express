package com.example.shop.express.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidActionException extends RuntimeException {

    /**
     * Instantiates a new Invalid action exception.
     *
     * @param message the message
     */
    public InvalidActionException(final String message) {
        super(message);
    }
}
