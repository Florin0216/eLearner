package com.example.backend.service;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RefreshTokenDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.dto.TokenPairDto;
import com.example.backend.model.User;

public interface AuthenticationService {

    User register(RegisterDto registerInput);

    User login(LoginDto loginInput);

    TokenPairDto refreshToken(RefreshTokenDto refreshTokenDto);
}
