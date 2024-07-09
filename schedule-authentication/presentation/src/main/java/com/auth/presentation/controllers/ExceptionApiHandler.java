package com.auth.presentation.controllers;

import com.auth.domain.dto.ExceptionResponseDto;
import com.auth.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionApiHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidAuthDataException.class, InvalidTokenSignException.class,
            TokenExpiredException.class, UserNotExistException.class})
    public ResponseEntity<ExceptionResponseDto> handleUnauthorizedStatusExceptions(RuntimeException e) {
        return new ResponseEntity<>(new ExceptionResponseDto(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({RoleNotExistException.class, UserExistException.class})
    public ResponseEntity<ExceptionResponseDto> handleBadRequestStatusExceptions(RuntimeException e) {
        return new ResponseEntity<>(new ExceptionResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException() {
        return new ResponseEntity<>("В доступе отказано", HttpStatus.FORBIDDEN);
    }

}
