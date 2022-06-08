package com.twoCube.couple.controller;

import com.twoCube.couple.dto.Code;
import com.twoCube.gifts.dto.NoteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/couple")
@RequiredArgsConstructor
@Api(tags = {"연인 API"})
public class CoupleController {

    @GetMapping("/code")
    @ApiOperation(value = "코드 발급받기 api")
    public ResponseEntity<Code> createNote(
//                                           @ApiIgnore @CurrentUser User user
    ){
        Code code = new Code();
        return ResponseEntity.ok(code);
    }
}
