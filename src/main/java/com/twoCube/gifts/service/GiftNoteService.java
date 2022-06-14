package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.request.NoteRequest;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface GiftNoteService {
    Long createNote(NoteRequest noteRequest, Member member);
}
