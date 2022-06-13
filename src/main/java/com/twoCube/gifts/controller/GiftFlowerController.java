package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.FlowerRequest;
import com.twoCube.gifts.dto.FlowerResponse;
import com.twoCube.gifts.service.GiftFlowerService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/gifts/flowers")
@RequiredArgsConstructor
@Api(tags = {"꽃 선물 API"})
public class GiftFlowerController {
    private final GiftFlowerService giftFlowerService;

    @GetMapping("/flowers")
    @ApiOperation(value = "랜덤으로 꽃 가져오기 api")
    public ResponseEntity<FlowerResponse> getFlower(
            @ApiIgnore @CurrentUser Member member
    ) {
        FlowerResponse flowerResponse = giftFlowerService.getRandomFlower(member);
        return ResponseEntity.ok(flowerResponse);
    }

    @PostMapping("/flowers")
    @ApiOperation(value = "꽃 선물하기 api")
    public ResponseEntity<Long> createFlower(@RequestBody FlowerRequest flowerRequest,
                                             @ApiIgnore @CurrentUser Member member
    ) {
        Long giftFlowerId = giftFlowerService.createFlower(flowerRequest, member);
        return ResponseEntity.ok(giftFlowerId);
    }
}
