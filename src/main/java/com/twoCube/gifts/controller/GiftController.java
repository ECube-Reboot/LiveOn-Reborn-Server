package com.twoCube.gifts.controller;

import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.gifts.dto.PillListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/polaroids")
    @ApiOperation(value = "폴라로이드 생성 api", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> createPolaroid(@RequestPart(required = false) MultipartFile polaroid,
                                               @RequestPart(required = false) String content
//                                           @ApiIgnore @CurrentUser User user
    ){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pills")
    @ApiOperation(value = "영양제 list 호출 api")
    public ResponseEntity<List<PillListResponse>> createPolaroid(
//                                           @ApiIgnore @CurrentUser User user
    ){
        List<PillListResponse> pillListResponse = new ArrayList<>();
        return ResponseEntity.ok(pillListResponse);
    }


}
