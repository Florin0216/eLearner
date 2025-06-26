package com.example.backend.controller;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RefreshTokenDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.dto.TokenPairDto;
import com.example.backend.model.User;
import com.example.backend.security.jwt.JwtUtil;
import com.example.backend.service.impl.AuthenticationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
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
