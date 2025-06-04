package com.example.elearner.service.impl;

import com.example.elearner.dto.LoginDto;
import com.example.elearner.dto.RegisterDto;
import com.example.elearner.model.User;
import com.example.elearner.repository.UserRepository;
import com.example.elearner.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
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

}
