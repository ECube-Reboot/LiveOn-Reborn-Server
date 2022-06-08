package com.twoCube.gifts.controller;

import com.twoCube.gifts.dto.NoteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/gifts")
@RequiredArgsConstructor
@Api(tags = {"선물 API"})
public class GiftController {

    @PostMapping("/notes")
    @ApiOperation(value = "쪽지 생성 api")
    public ResponseEntity<Long> createNote(@RequestBody NoteRequest noteRequest
//                                           @ApiIgnore @CurrentUser User user
                                           ){

        return ResponseEntity.ok().build();
    }

//    @ApiOperation(value = "프로필 설정")
//    @PatchMapping(path = "/user/profile")
//    public ResponseEntity<ProfileResponse> updateProfile(@ApiIgnore @CurrentUser User user, @RequestPart(required = false) MultipartFile profilePicture,
//                                                         @RequestPart(required = false) String nickName) {
//        ProfileResponse profileResponse = userService.updateUserProfile(user, nickName, profilePicture);
//        return ResponseEntity.ok(profileResponse);
//    }

    @PostMapping("/polaroid")
    @ApiOperation(value = "폴라로이드 생성 api", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> createPolaroid(@RequestPart(required = false) MultipartFile polaroid,
                                               @RequestPart(required = false) String content
//                                           @ApiIgnore @CurrentUser User user
    ){
        return ResponseEntity.ok().build();
    }


}
