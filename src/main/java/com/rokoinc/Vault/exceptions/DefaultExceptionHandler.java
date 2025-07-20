package com.rokoinc.Vault.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @ExceptionHandler({MethodArgumentNotValidException.class,
            HandlerMethodValidationException.class,
            MethodArgumentTypeMismatchException.class})
    public ResponseEntity<APIErrorModel> handleBadRequests(
            Exception exception,
            HttpServletRequest request
    ) {
        List<String> errors = new ArrayList<>();
        if (exception instanceof MethodArgumentNotValidException argumentException ) {
            errors = argumentException
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
        } else if (exception instanceof HandlerMethodValidationException multipleArgumentException){
            errors = multipleArgumentException
                    .getAllErrors()
                    .stream()
                    .map(MessageSourceResolvable::getDefaultMessage)
                    .toList();
        } else if (exception instanceof MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
            errors.add(methodArgumentTypeMismatchException
                    .getName());
        }


        APIErrorModel error = new APIErrorModel(
                request.getRequestURI(),
                "Bad Request",
                LocalDateTime.now(),
                errors
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<APIErrorModel> handleBadCredentialsException(
            Exception exception,
            HttpServletRequest request
    ) {
        APIErrorModel error = new APIErrorModel(
                request.getRequestURI(),
                "Email or Password is incorrect",
                LocalDateTime.now(),
                List.of()
        );

        return new  ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
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
        System.out.println(exception.getClass());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
