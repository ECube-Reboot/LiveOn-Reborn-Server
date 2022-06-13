package com.twoCube.gifts.dto;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.Flower;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftPill;
import com.twoCube.gifts.domain.Pill;
import com.twoCube.members.domain.Member;
import lombok.Getter;

@Getter
public class PillRequest {
    private long pillId;
    private String pillName;
    private String pillEffect;

    public GiftPill toEntity(Member member, Couple couple, Pill pill) {
        return GiftPill.builder().couple(couple).member(member)
                .description(pillEffect).name(pillName).pill(pill).build();
    }
}
