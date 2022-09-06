package com.twoCube.members.controller;


import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.members.domain.Member;
import com.twoCube.members.dto.*;
import com.twoCube.members.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Api(tags = {"회원 API"})
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    @ApiOperation(value = "회원 정보 입력 api")
    public ResponseEntity<Long> saveMemberInfo(@RequestBody MemberInfoRequest memberInfoRequest,
                                               @ApiIgnore @CurrentUser Member member
    ) {
        System.out.println(member.getCouple());
        System.out.println(memberInfoRequest.getBirthDay());
        Long coupleId = memberService.updateMemberInfo(member, memberInfoRequest);
        return ResponseEntity.ok(coupleId);
    }

    @PatchMapping("/withdrawl")
    @ApiOperation(value = "회원 탈퇴 api")
    public ResponseEntity<Long> withdrawlMemberShip (@ApiIgnore @CurrentUser Member member
    ) {
        memberService.withdrawlMemberShip(member);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @ApiOperation(value = "프로필 보기 api")
    public ResponseEntity<ProfileResponse> getProfile(@ApiIgnore @CurrentUser Member member) {
        ProfileResponse profileResponse = memberService.getProfile(member);
        return ResponseEntity.ok(profileResponse);
    }

    @PatchMapping("/nickname")
    @ApiOperation(value = "닉네임 편집 api")
    public ResponseEntity<ProfileResponse> updateNickname(@RequestBody NicknameRequest nicknameRequest,
                                                         @ApiIgnore @CurrentUser Member member) {
        memberService.updateNickname(member, nicknameRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/birthday")
    @ApiOperation(value = "생일 편집 api")
    public ResponseEntity<ProfileResponse> updateBirthday(@RequestBody BirthdayRequest birthdayRequest,
                                                          @ApiIgnore @CurrentUser Member member) {
        memberService.updateBirthday(member, birthdayRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/officialDate")
    @ApiOperation(value = "닉네임 편집 api")
    public ResponseEntity<ProfileResponse> updateOfficialDate(@RequestBody OfficialDateRequest officialDateRequest,
                                                              @ApiIgnore @CurrentUser Member member) {
        memberService.updateOfficialDate(member, officialDateRequest);
        return ResponseEntity.noContent().build();
    }
}
