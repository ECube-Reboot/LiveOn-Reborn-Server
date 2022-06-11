package com.twoCube.members.controller;


import com.twoCube.members.dto.MemberInfoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Api(tags = {"회원 API"})
public class MemberController {

    @PostMapping("/register")
    @ApiOperation(value = "회원 정보 입력 api")
    public ResponseEntity<Long> saveMemberInfo(@RequestBody MemberInfoRequest memberInfoRequest
//                                           @ApiIgnore @CurrentUser User user
    ){
        return ResponseEntity.ok().build();
    }
}
