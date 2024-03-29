package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.detail.UserFlowerResponse;
import com.twoCube.gifts.dto.list.GiftFlowerResponse;
import com.twoCube.gifts.dto.request.FlowerRequest;
import com.twoCube.gifts.service.GiftFlowerService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gifts/flowers")
@RequiredArgsConstructor
@Api(tags = {"꽃 선물 API"})
public class GiftFlowerController {
    private final GiftFlowerService giftFlowerService;

    @PostMapping("")
    @ApiOperation(value = "꽃 선물하기 api")
    public ResponseEntity<Long> createFlower(@RequestBody FlowerRequest flowerRequest,
                                             @ApiIgnore @CurrentUser Member member
    ) {
        Long giftFlowerId = giftFlowerService.createFlower(flowerRequest, member);
        return ResponseEntity.ok(giftFlowerId);
    }

    @GetMapping("")
    @ApiOperation(value = "꽃 선물보기 리스트 api")
    public ResponseEntity<List<GiftFlowerResponse>> getFlowerList(@ApiIgnore @CurrentUser Member member
    ) {
        List<GiftFlowerResponse> giftFlowerResponseList = giftFlowerService.getFlowerList(member);
        return ResponseEntity.ok(giftFlowerResponseList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "꽃 선물보기 api")
    public ResponseEntity<UserFlowerResponse> getFlower(
            @PathVariable Long id,
            @ApiIgnore @CurrentUser Member member
    ) {
        UserFlowerResponse giftFlowerResponse= giftFlowerService.getFlower(id);
        return ResponseEntity.ok(giftFlowerResponse);
    }
}
