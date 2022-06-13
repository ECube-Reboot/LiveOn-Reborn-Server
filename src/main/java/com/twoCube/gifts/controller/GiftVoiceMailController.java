package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.service.GiftVoiceMailService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/gifts/voicemail")
@RequiredArgsConstructor
@Api(tags = {"음성메시지 선물 API"})
public class GiftVoiceMailController {

    private final GiftVoiceMailService giftVoiceMailService;

    @PostMapping("")
    @ApiOperation(value = "음성메시지 선물하기 api")
    public ResponseEntity<Long> createVoicemail(@RequestPart(required = false) MultipartFile voiceMail,
                                               @RequestPart(required = false) String title,
                                               @ApiIgnore @CurrentUser Member member
    ) {
        long giftVoiceMailId = giftVoiceMailService.createVoicemail(voiceMail, title, member);
        return ResponseEntity.ok(giftVoiceMailId);
    }
}
