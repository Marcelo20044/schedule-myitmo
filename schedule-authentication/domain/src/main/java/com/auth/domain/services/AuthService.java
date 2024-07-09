package com.auth.domain.services;

import com.auth.domain.config.jwt.JwtUtils;
import com.auth.domain.dto.TokenDto;
import com.auth.domain.dto.UserDto;
import com.auth.domain.exceptions.InvalidAuthDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public TokenDto createToken(UserDto userDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.username(), userDto.password())
            );
        } catch (BadCredentialsException e) {
            throw new InvalidAuthDataException("Неправильный логин или пароль");
        }

        UserDetails userDetails = userService.loadUserByUsername(userDto.username());
        return new TokenDto(jwtUtils.generateToken(userDetails));
    }
}
