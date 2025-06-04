package com.example.elearner.service;

import com.example.elearner.dto.LoginDto;
import com.example.elearner.dto.RegisterDto;
import com.example.elearner.model.User;

public interface AuthenticationService {

    User register(RegisterDto registerInput);

    User login(LoginDto loginInput);
}
