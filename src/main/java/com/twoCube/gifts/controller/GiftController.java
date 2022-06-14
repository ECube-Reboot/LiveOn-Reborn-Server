package com.twoCube.gifts.controller;

import com.twoCube.gifts.dto.request.MainRequest;
import com.twoCube.gifts.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gifts")
@RequiredArgsConstructor
@Api(tags = {"선물 API"})
public class GiftController {

    private final GiftService giftService;

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
