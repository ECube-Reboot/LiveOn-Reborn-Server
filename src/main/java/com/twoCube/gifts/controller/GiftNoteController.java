package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.gifts.service.GiftNoteService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/gifts/notes")
@RequiredArgsConstructor
@Api(tags = {"쪽지 선물 API"})
public class GiftNoteController {

    private final GiftNoteService giftNoteService;

    @PostMapping("")
    @ApiOperation(value = "쪽지 선물하기 api")
    public ResponseEntity<Long> createNote(@RequestBody NoteRequest noteRequest,
                                           @ApiIgnore @CurrentUser Member member
    ) {
        Long giftNoteId = giftNoteService.createNote(noteRequest, member);
        return ResponseEntity.ok(giftNoteId);
    }
}
