package com.dev.opendelivery.order.exception.handler;

import com.dev.opendelivery.order.exception.EntityNotFoundException;
import org.springframework.http.*;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String INVALIDATION_MESSAGE = "generic.invalidation.message";

    private static final String GENERIC_ERROR_MESSAGE = "generic.error.message";

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiError.Field> fields = getFieldsWithError(ex);

        ApiError apiError = ApiError.builder()
                .status(status.value())
                .title(INVALIDATION_MESSAGE)
                .detail("generic.validation.exception.detail.message")
                .fields(fields)
                .build();

        headers.setContentType(APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
        var status = INTERNAL_SERVER_ERROR;

        var apiError = ApiError
                .builder()
                .title(GENERIC_ERROR_MESSAGE)
                .status(status.value())
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        var status = NOT_FOUND;

        var apiError = ApiError.builder()
                .title(ex.getMessage())
                .status(status.value())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError.builder()
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        headers.setContentType(APPLICATION_PROBLEM_JSON);
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private List<ApiError.Field> getFieldsWithError(Exception ex) {
        return ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> ApiError.Field
                        .builder()
                        .name(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();
    }

}
