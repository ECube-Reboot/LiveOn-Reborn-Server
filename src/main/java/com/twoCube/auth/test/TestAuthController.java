package com.twoCube.auth.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"인증 관련 API"})
public class TestAuthController {

    private final TestAuthService authUserService;

    @ApiOperation(value = "임시 로그인 및 회원가입 api")
    @PostMapping("/login")
    public ResponseEntity<TestAuthResponse> getTokens(@RequestBody TestAuthRequest authRequest){
        TestAuthResponse authResponse = authUserService.testSignUpOrLogIn(authRequest);
        return ResponseEntity.ok(authResponse);
    }

//    @ApiOperation(value= "토큰 재발급")
//    @PostMapping("/reissue")
//    public ResponseEntity<TokenReissue> reissue(@RequestBody TokenReissue tokenReissueRequest) {
//        TokenReissue tokenReissueResponse = authUserService.reissue(tokenReissueRequest);
//        return ResponseEntity.ok(tokenReissueResponse);
//    }
//
//    @ApiOperation(value = "로그아웃")
//    @PatchMapping("/logout")
//    public ResponseEntity<Void> logOut (@ApiIgnore @CurrentUser User user) {
//        authUserService.logout(user);
//        return ResponseEntity.ok().build();
//    }
//
//    @ApiOperation(value = "회원탈퇴")
//    @PatchMapping("/withdrawl")
//    public ResponseEntity<Void> withdrawl (@ApiIgnore @CurrentUser User user) {
//        authUserService.withdrawl(user);
//        return ResponseEntity.ok().build();
//    }
}
