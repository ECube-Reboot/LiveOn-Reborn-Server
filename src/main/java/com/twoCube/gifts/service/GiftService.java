package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.members.domain.Member;

public interface GiftService {
    Long createNote(NoteRequest noteRequest, Member member);
}
