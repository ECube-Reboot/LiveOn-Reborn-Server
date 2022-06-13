package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.dto.*;
import com.twoCube.gifts.service.*;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gifts")
@RequiredArgsConstructor
@Api(tags = {"선물 API"})
public class GiftController {

    private final GiftService giftService;
//    private final GiftNoteService giftNoteService;
    private final GiftPillService giftPillService;
//    private final GiftFlowerService giftFlowerService;
    private final GiftPolaroidService giftPolaroidService;




    @PostMapping("/polaroids")
    @ApiOperation(value = "폴라로이드 선물하기 api")
    public ResponseEntity<Long> createPolaroid(@RequestPart(required = false) MultipartFile polaroid,
                                               @RequestPart(required = false, value = "comment") String comment,
                                               @ApiIgnore @CurrentUser Member member
    ) {
        long giftPolaroidId = giftPolaroidService.createPolaroid(polaroid, comment, member);
        return ResponseEntity.ok(giftPolaroidId);
    }

    @PostMapping("/pills")
    @ApiOperation(value = "영양제 선물하기 api")
    public ResponseEntity<Long> createPill(@RequestBody PillRequest pillRequest,
                                           @ApiIgnore @CurrentUser Member member
    ) {
        Long giftPillId = giftPillService.createPill(pillRequest, member);
        return ResponseEntity.ok(giftPillId);
    }

    @GetMapping("/pills")
    @ApiOperation(value = "영양제 list 호출 api")
    public ResponseEntity<List<PillListResponse>> getPillList() {
        List<PillListResponse> pillListResponse = giftPillService.getPillList();
        return ResponseEntity.ok(pillListResponse);
    }

    @GetMapping("/main")
    @ApiOperation(value = "선물 메인 api")
    public ResponseEntity<MainRequest> getMain(
//                                           @ApiIgnore @CurrentUser User user
    ) {
        System.out.println("print");
        MainRequest mainRequest = new MainRequest();
        return ResponseEntity.ok().build();
    }
}
