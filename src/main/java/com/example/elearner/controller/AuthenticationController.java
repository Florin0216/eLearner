package com.example.elearner.controller;

import com.example.elearner.dto.LoginDto;
import com.example.elearner.dto.RefreshTokenDto;
import com.example.elearner.dto.RegisterDto;
import com.example.elearner.dto.TokenPairDto;
import com.example.elearner.model.User;
import com.example.elearner.security.jwt.JwtUtil;
import com.example.elearner.service.impl.AuthenticationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationServiceImpl authenticationService, JwtUtil jwtUtil) {
        this.authenticationService = authenticationService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerUserDto) {
        User registeredUser = authenticationService.register(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        User authenticatedUser = authenticationService.login(loginDto);
        TokenPairDto tokens = jwtUtil.generateTokenPair(authenticatedUser);
        return ResponseEntity.ok(tokens);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {
        TokenPairDto tokens = authenticationService.refreshToken(refreshTokenDto);
        return ResponseEntity.ok(tokens);
    }
}
