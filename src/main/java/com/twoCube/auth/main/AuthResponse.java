package com.twoCube.auth.main;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private Boolean isNewMember;
    private Boolean userSettingDone;
}
