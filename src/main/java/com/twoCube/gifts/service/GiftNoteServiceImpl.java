package com.twoCube.gifts.service;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.gifts.repository.GiftNoteRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GiftNoteServiceImpl implements  GiftNoteService{

    private final GiftNoteRepository giftNoteRepository;

    @Override
    public Long createNote(NoteRequest noteRequest, Member member) {
        Couple couple = member.getCouple();
        GiftNote giftNote = noteRequest.toEntity(member, couple);
        GiftNote giftNoteId = giftNoteRepository.save(giftNote);
        return giftNoteId.getId();
    }
}
