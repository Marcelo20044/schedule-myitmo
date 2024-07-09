package com.auth.presentation.controllers;

import com.auth.domain.dto.TokenDto;
import com.auth.domain.dto.UserDto;
import com.auth.domain.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<TokenDto> createToken(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authService.createToken(userDto));
    }

    @PostMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
}