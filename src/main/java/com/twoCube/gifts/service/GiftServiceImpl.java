package com.twoCube.gifts.service;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.Flower;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.dto.FlowerResponse;
import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.gifts.repository.FlowerRepository;
import com.twoCube.gifts.repository.GiftNoteRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService{
    private final GiftNoteRepository giftNoteRepository;
    private final FlowerRepository flowerRepository;

    @Override
    public Long createNote(NoteRequest noteRequest, Member member) {
        Couple couple = member.getCouple();
        GiftNote giftNote = noteRequest.toEntity(member, couple);
        GiftNote giftNoteId = giftNoteRepository.save(giftNote);
        return giftNoteId.getId();
    }

    @Override
    public FlowerResponse getRandomFlower(Member member) {
        Flower flower = flowerRepository.findFlowerByRand();
        return new FlowerResponse(flower);
    }
}
