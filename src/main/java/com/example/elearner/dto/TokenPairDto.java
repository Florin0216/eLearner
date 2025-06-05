package com.example.elearner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenPairDto {
    private String accessToken;
    private String refreshToken;
}
