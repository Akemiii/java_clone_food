package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends BusinessException{
    public NotFoundException() {
        super("NOT_FOUND", HttpStatus.NOT_FOUND.toString());
    }
}
