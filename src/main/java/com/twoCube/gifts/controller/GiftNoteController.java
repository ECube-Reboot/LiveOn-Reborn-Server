package com.twoCube.gifts.controller;

import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.detail.UserNoteResponse;
import com.twoCube.gifts.dto.detail.UserPolaroidResponse;
import com.twoCube.gifts.dto.list.GiftMemoResponse;
import com.twoCube.gifts.dto.list.GiftPolaroidResponse;
import com.twoCube.gifts.dto.request.NoteRequest;
import com.twoCube.gifts.service.GiftNoteService;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

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

    @GetMapping("")
    @ApiOperation(value = "쪽지 선물보기 리스트 api")
    public ResponseEntity<List<GiftNoteResponse>> getNoteList(@ApiIgnore @CurrentUser Member member
    ) {
        List<GiftNoteResponse> giftNoteResponseList= giftNoteService.getMemoList(member);
        return ResponseEntity.ok(giftNoteResponseList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "쪽지 선물보기 api")
    public ResponseEntity<UserNoteResponse> getNote(
            @PathVariable Long id,
            @ApiIgnore @CurrentUser Member member
    ) {
        UserNoteResponse giftNoteResponse= giftNoteService.getNote(id);
        return ResponseEntity.ok(giftNoteResponse);
    }
}
