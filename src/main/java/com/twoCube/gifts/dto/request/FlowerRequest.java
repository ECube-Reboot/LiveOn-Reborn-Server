package com.twoCube.gifts.dto.request;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.EFlowerName;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.members.domain.Member;
import lombok.Getter;

@Getter
public class FlowerRequest {
    private String flowerName;
    private String message;

    public GiftFlower toEntity(Member member, Couple couple, String name) {
        return GiftFlower.builder().couple(couple).member(member).message(message).name(EFlowerName.valueOf(name)).build();
    }
}
