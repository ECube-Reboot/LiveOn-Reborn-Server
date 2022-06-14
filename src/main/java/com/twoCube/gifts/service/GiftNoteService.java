package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.detail.UserAudioResponse;
import com.twoCube.gifts.dto.detail.UserNoteResponse;
import com.twoCube.gifts.dto.list.GiftMemoResponse;
import com.twoCube.gifts.dto.request.NoteRequest;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftNoteService {
    Long createNote(NoteRequest noteRequest, Member member);
    List<GiftMemoResponse> getMemoList(Member member);
    UserNoteResponse getNote(Long id);
}
