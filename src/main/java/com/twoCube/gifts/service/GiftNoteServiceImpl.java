package com.twoCube.gifts.service;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.domain.GiftVoicemail;
import com.twoCube.gifts.dto.detail.UserAudioResponse;
import com.twoCube.gifts.dto.detail.UserNoteResponse;
import com.twoCube.gifts.dto.list.GiftNoteResponse;
import com.twoCube.gifts.dto.list.GiftPolaroidResponse;
import com.twoCube.gifts.dto.request.NoteRequest;
import com.twoCube.gifts.repository.GiftNoteRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<GiftNoteResponse> getNoteList(Member member) {
        List<GiftNote> giftNoteList =
                giftNoteRepository.findAllByCouple(member.getCouple());
        return GiftNoteResponse.listFrom(giftNoteList);
    }

    @Override
    public UserNoteResponse getNote(Long id) {
        GiftNote giftNote =
                giftNoteRepository.getById(id);
        return UserNoteResponse.from(giftNote);
    }
}
