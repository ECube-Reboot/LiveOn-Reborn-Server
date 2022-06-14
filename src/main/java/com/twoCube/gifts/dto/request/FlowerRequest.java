package com.twoCube.gifts.dto.request;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.Flower;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.members.domain.Member;
import lombok.Getter;

@Getter
public class FlowerRequest {
    private long flowerId;
    private String message;

    public GiftFlower toEntity(Member member, Couple couple, Flower flower) {
        return GiftFlower.builder().couple(couple).member(member).message(message).flower(flower).build();
    }
}
