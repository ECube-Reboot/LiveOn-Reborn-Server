package com.twoCube.gifts.service;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftPill;
import com.twoCube.gifts.domain.Pill;
import com.twoCube.gifts.dto.PillListResponse;
import com.twoCube.gifts.dto.request.PillRequest;
import com.twoCube.gifts.repository.GiftPillRepository;
import com.twoCube.gifts.repository.PillRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftPillServiceImpl implements GiftPillService{

    private final PillRepository pillRepository;
    private final GiftPillRepository giftPillRepository;

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
