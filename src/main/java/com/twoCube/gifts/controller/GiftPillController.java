package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.PillListResponse;
import com.twoCube.gifts.dto.request.PillRequest;
import com.twoCube.gifts.service.GiftPillService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gifts/pills")
@RequiredArgsConstructor
@Api(tags = {"영양제 선물 API"})
public class GiftPillController {
    private final GiftPillService giftPillService;

    @PostMapping("")
    @ApiOperation(value = "영양제 선물하기 api")
    public ResponseEntity<Long> createPill(@RequestBody PillRequest pillRequest,
                                           @ApiIgnore @CurrentUser Member member
    ) {
        Long giftPillId = giftPillService.createPill(pillRequest, member);
        return ResponseEntity.ok(giftPillId);
    }

    @GetMapping("")
    @ApiOperation(value = "영양제 list 호출 api")
    public ResponseEntity<List<PillListResponse>> getPillList() {
        List<PillListResponse> pillListResponse = giftPillService.getPillList();
        return ResponseEntity.ok(pillListResponse);
    }
}
