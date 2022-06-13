package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.service.GiftPolaroidService;
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
@RequestMapping("/api/v1/gifts/polaroids")
@RequiredArgsConstructor
@Api(tags = {"폴라로이드 선물 API"})
public class GiftPolaroidController {

    private final GiftPolaroidService giftPolaroidService;

    @PostMapping("")
    @ApiOperation(value = "폴라로이드 선물하기 api")
    public ResponseEntity<Long> createPolaroid(@RequestPart(required = false) MultipartFile polaroid,
                                               @RequestPart(required = false, value = "comment") String comment,
                                               @ApiIgnore @CurrentUser Member member
    ) {
        long giftPolaroidId = giftPolaroidService.createPolaroid(polaroid, comment, member);
        return ResponseEntity.ok(giftPolaroidId);
    }
}
