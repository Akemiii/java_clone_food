package org.example.commons.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiExceptionResponse {
    private int status;
    private String path;
    private List<ErrorDetail> errors;



    @Getter
    @Setter
    static class ErrorDetail {
        private String origin;
        private String errorCode;
        private String message;
        private List<String> fields;
    }
}