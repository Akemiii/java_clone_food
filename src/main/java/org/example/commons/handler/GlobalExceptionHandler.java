package org.example.commons.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${spring.application.name}")
    private String application;

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiExceptionResponse> handle(HttpServletRequest request, Exception ex) {
        final var response = customErrorResponse(request);
        final var errorDetail = customErrorDetail(ex.getLocalizedMessage(), null);
        response.getErrors().add(errorDetail);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionResponse> handle(HttpServletRequest request, MethodArgumentNotValidException ex) {
        final var response = customErrorResponse(request);

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            final var errorDetail = customErrorDetail(fieldError.getDefaultMessage(), fieldError.getField());
            response.getErrors().add(errorDetail);
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private ApiExceptionResponse.ErrorDetail customErrorDetail(String defaultMessage, String field) {
        final var errorDetail = new ApiExceptionResponse.ErrorDetail();

        errorDetail.setOrigin(this.application);
        errorDetail.setErrorCode("INVALID_PAYLOAD");
        errorDetail.setMessage(defaultMessage);

        if (nonNull(field)) {
            errorDetail.setFields(List.of(field));
        }

        return errorDetail;
    }

    private ApiExceptionResponse customErrorResponse(HttpServletRequest request) {
        final var response = new ApiExceptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setPath(request.getServletPath());
        response.setErrors(new ArrayList<>());

        return response;
    }
}
