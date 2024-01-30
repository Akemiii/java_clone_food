package org.example.exception;

public class BusinessException extends RuntimeException{
    private String message;
    private String httpStatus;

    public BusinessException(String message, String httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
