package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.detail.UserAudioResponse;
import com.twoCube.gifts.dto.detail.UserPolaroidResponse;
import com.twoCube.gifts.dto.list.GiftPolaroidResponse;
import com.twoCube.gifts.dto.list.GiftVoiceMailResponse;
import com.twoCube.gifts.service.GiftVoiceMailService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

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
                                                @RequestPart(required = false) String voiceMailDuration,
                                                @ApiIgnore @CurrentUser Member member
    ) {
        long giftVoiceMailId = giftVoiceMailService.createVoicemail(voiceMail, title, voiceMailDuration,member);
        return ResponseEntity.ok(giftVoiceMailId);
    }

    @GetMapping("")
    @ApiOperation(value = "음성메시지 선물보기 리스트 api")
    public ResponseEntity<List<GiftVoiceMailResponse>> getVoiceMailList(@ApiIgnore @CurrentUser Member member
    ) {
        List<GiftVoiceMailResponse> giftVoiceMailResponseList = giftVoiceMailService.getVoiceMailList(member);
        return ResponseEntity.ok(giftVoiceMailResponseList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "음성메시지 선물보기 api")
    public ResponseEntity<UserAudioResponse> getVoicemail(
            @PathVariable Long id,
            @ApiIgnore @CurrentUser Member member
    ) {
        UserAudioResponse giftVoiceMailResponse = giftVoiceMailService.getVoiceMail(id);
        return ResponseEntity.ok(giftVoiceMailResponse);
    }
}
