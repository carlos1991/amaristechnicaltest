package com.amaris.technicaltest.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@RestControllerAdvice
@Log4j2
public class CustomExceptionHandler {
    private static final String EXCEPTION_LOG = "Exception {}";

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleConstrainViolationException(ConstraintViolationException ex) {
        log.debug(EXCEPTION_LOG, ex.getMessage(), ex);
        return ErrorDto.builder()
                .type(ex.getClass().getCanonicalName())
                .message(ex.getMessage()).build();
    }

    @ExceptionHandler({ServerWebInputException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleServerWebInputException(ServerWebInputException ex) {
        log.debug(EXCEPTION_LOG, ex.getMessage(), ex);
        String message = Optional.ofNullable(ex.getCause()).map(
                cause -> ex.getReason().concat(" " + cause.getMessage())
        ).orElse(ex.getReason());

        return ErrorDto.builder()
                .type(ex.getClass().getCanonicalName())
                .message(message).build();
    }

    // Default exception handler for uncaught exceptions
    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto unhandledExceptions(Exception ex) {
        log.error(EXCEPTION_LOG, ex.getMessage(), ex);
        return ErrorDto.builder()
                .type(ex.getClass().getCanonicalName())
                .message(ex.getMessage()).build();
    }
}
