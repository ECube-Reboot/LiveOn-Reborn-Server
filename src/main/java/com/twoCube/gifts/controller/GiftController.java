package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.MainResponse;
import com.twoCube.gifts.dto.UserGiftedResponse;
import com.twoCube.gifts.service.*;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/gifts")
@RequiredArgsConstructor
@Api(tags = {"선물 API"})
public class GiftController {

    private final GiftService giftService;

    @GetMapping("/main")
    @ApiOperation(value = "선물 메인 api")
    public ResponseEntity<MainResponse> getMain(
            @ApiIgnore @CurrentUser Member member
    ) {
        MainResponse mainResponse = giftService.getMain(member);
        return ResponseEntity.ok(mainResponse);
    }

    @GetMapping("/main/gift-exists")
    @ApiOperation(value = "선물 존재 여부 api")
    public ResponseEntity<UserGiftedResponse> getUserGifted(
            @ApiIgnore @CurrentUser Member member
    ) {
        Boolean userGifted = giftService.haveUserGifted(member);
        return ResponseEntity.ok(UserGiftedResponse.builder()
                .userGifted(userGifted).build());
    }
}
