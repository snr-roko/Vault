package com.rokoinc.Vault.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIErrorModel> handleNotFoundExceptions(
            ResourceNotFoundException exception,
            HttpServletRequest request
            ) {
        APIErrorModel error = new APIErrorModel(
                request.getRequestURI(),
                exception.getMessage(),
                LocalDateTime.now(),
                List.of()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<APIErrorModel> handleDuplicateResourceExceptions(
            DuplicateResourceException exception,
            HttpServletRequest request
    ) {
        APIErrorModel error = new APIErrorModel(
                request.getRequestURI(),
                exception.getMessage(),
                LocalDateTime.now(),
                List.of()
        );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIErrorModel> handleBadRequests(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ) {
        List<String> errors = exception
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        APIErrorModel error = new APIErrorModel(
                request.getRequestURI(),
                "Bad Request",
                LocalDateTime.now(),
                errors
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIErrorModel> handleAllOtherExceptions(
            Exception exception,
            HttpServletRequest request
    ) {
        APIErrorModel error = new APIErrorModel(
                request.getRequestURI(),
                exception.getMessage(),
                LocalDateTime.now(),
                List.of()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
