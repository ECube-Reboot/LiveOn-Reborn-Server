package com.twoCube.auth.test;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestAuthResponse {
    private String accessToken;
    private String refreshToken;
    private Boolean isNewMember;
    private Boolean userSettingDone;
}
