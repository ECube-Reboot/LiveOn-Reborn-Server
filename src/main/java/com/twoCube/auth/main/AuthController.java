package com.twoCube.auth.main;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"토큰 API"})
public class AuthController {

    private final AuthService authService;

    @ApiOperation(value = "로그인 및 회원가입 api")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> getTokens(@RequestBody AuthRequest authRequest){
        AuthResponse authResponse = authService.signUpOrLogIn(authRequest);
        return ResponseEntity.ok(authResponse);
    }

    @ApiOperation(value= "토큰 재발급")
    @PostMapping("/reissue")
    public ResponseEntity<TokenReissueDto> reissue(@RequestBody TokenReissueDto tokenReissueRequest) {
        TokenReissueDto tokenReissueResponse = authService.reissue(tokenReissueRequest);
        return ResponseEntity.ok(tokenReissueResponse);
    }
}
