package com.twoCube.gifts.controller;

import com.twoCube.gifts.dto.NoteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
