package com.twoCube.gifts.service;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.*;
import com.twoCube.gifts.dto.*;
import com.twoCube.gifts.repository.*;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService{
    private final GiftNoteRepository giftNoteRepository;
    private final FlowerRepository flowerRepository;
    private final GiftFlowerRepository giftFlowerRepository;
    private final PillRepository pillRepository;
    private final GiftPillRepository giftPillRepository;

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

    @Override
    public Long createFlower(FlowerRequest flowerRequest, Member member) {
        Couple couple = member.getCouple();
        Flower flower = flowerRepository.getById(flowerRequest.getFlowerId());
        GiftFlower giftFlower = flowerRequest.toEntity(member, couple, flower);
        giftFlowerRepository.save(giftFlower);
        return giftFlower.getId();
    }

    @Override
    public List<PillListResponse> getPillList() {
        return PillListResponse.listFrom(pillRepository.findAll());
    }

    @Override
    public Long createPill(PillRequest pillRequest, Member member) {
        Couple couple = member.getCouple();
        Pill pill = pillRepository.getById(pillRequest.getPillId());
        GiftPill giftPill = pillRequest.toEntity(member, couple, pill);
        giftPillRepository.save(giftPill);
        return  giftPill.getId();
    }
}
