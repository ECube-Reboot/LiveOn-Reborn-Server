package com.twoCube.gifts.controller;

import com.twoCube.gifts.dto.NoteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/polaroid")
    @ApiOperation(value = "폴라로이드 생성 api", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> createPolaroid(@RequestPart(required = false) MultipartFile polaroid,
                                               @RequestPart(required = false) String content
//                                           @ApiIgnore @CurrentUser User user
    ){
        return ResponseEntity.ok().build();
    }


}
