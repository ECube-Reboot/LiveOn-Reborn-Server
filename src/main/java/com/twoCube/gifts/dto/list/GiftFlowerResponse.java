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
    private String giftFlowerName;

    public static GiftFlowerResponse from(GiftFlower giftFlower) {
        return GiftFlowerResponse.builder()
                .giftFlowerName(giftFlower.getName().toString())
                .build();
    }

    public static List<GiftFlowerResponse> listFrom(List<GiftFlower> giftFlowerList) {
        return giftFlowerList.stream()
                .map(GiftFlowerResponse::from)
                .collect(Collectors.toList());
    }

}
