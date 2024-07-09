package com.auth.domain.config.exceptionHandler;

import com.auth.domain.dto.ExceptionResponseDto;
import com.auth.domain.exceptions.InvalidTokenSignException;
import com.auth.domain.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JwtExceptionApiHandler {
    @ExceptionHandler({TokenExpiredException.class, InvalidTokenSignException.class})
    public ResponseEntity<ExceptionResponseDto> handleTokenExceptions(RuntimeException e) {
        return new ResponseEntity<>(new ExceptionResponseDto(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
