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

        //TODO:: faz sentido utilizar esse campo? Remover caso não houver integração com outros microserviços,
        //se houver integração com outros serviços, transformar em lib para ser utilizada por outros microserviços
        private String origin;
        private String errorCode;
        private String message;
        private List<String> fields;
    }
}