package com.twoCube.gifts.dto.list;

import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftNote;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class GiftFlowerResponse {
    private long giftFlowerId;
    private String giftFlowerImage;

    public static GiftFlowerResponse from(GiftFlower giftFlower) {
        return GiftFlowerResponse.builder()
                .giftFlowerId(giftFlower.getId())
                .giftFlowerImage(giftFlower.getFlower().getImage())
                .build();
    }

    public static List<GiftFlowerResponse> listFrom(List<GiftFlower> giftFlowerList) {
        return giftFlowerList.stream()
                .map(GiftFlowerResponse::from)
                .collect(Collectors.toList());
    }

}
