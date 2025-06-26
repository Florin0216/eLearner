package com.example.backend.service.impl;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RefreshTokenDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.dto.TokenPairDto;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.jwt.JwtUtil;
import com.example.backend.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public User register(RegisterDto registerInput) {
        User newUser = new User();
        newUser.setUsername(registerInput.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerInput.getPassword()));
        newUser.setEmail(registerInput.getEmail());
        return userRepository.save(newUser);
    }

    public User login(LoginDto loginInput) {
        User user = userRepository.findByUsername(loginInput.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginInput.getUsername(),
                        loginInput.getPassword()
                )
        );

        return user;
    }

    public TokenPairDto refreshToken(RefreshTokenDto refreshTokenDto) {
        String refreshToken = refreshTokenDto.getRefreshToken();
        String username = jwtUtil.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        String accessToken = jwtUtil.generateAccessToken(user);

        return new TokenPairDto(accessToken, refreshToken);

    }

}
