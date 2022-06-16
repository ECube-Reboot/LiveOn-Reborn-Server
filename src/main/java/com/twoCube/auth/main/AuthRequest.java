package com.twoCube.auth.main;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "인증 요청")
public class AuthRequest {
    private String accessToken;
}
