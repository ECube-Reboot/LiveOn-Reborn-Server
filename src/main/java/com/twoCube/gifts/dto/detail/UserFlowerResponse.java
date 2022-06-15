package com.twoCube.gifts.dto.detail;

import com.twoCube.gifts.domain.GiftFlower;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserFlowerResponse {

    private long userSentFlowerId;
    private String message;
    private String flowerImage;
    private String flowerDescription;
    private String flowerName;
    private String senderName;
    private LocalDate sentDate;

    public static UserFlowerResponse from(GiftFlower giftFlower) {

        return UserFlowerResponse.builder()
                .userSentFlowerId(giftFlower.getId())
                .message(giftFlower.getMessage())
                .senderName(giftFlower.getMember().getNickName())
                .flowerDescription(giftFlower.getFlower().getDescription())
                .flowerName(giftFlower.getFlower().getName())
                .flowerImage(giftFlower.getFlower().getImage())
                .sentDate(giftFlower.getCreatedAt().toLocalDate())
                .build();
    }

    public static List<UserFlowerResponse> listFrom(List<GiftFlower> giftFlowers) {
        if (giftFlowers == null) {
            return null;
        }
        return giftFlowers.stream()
                .map(giftFlower -> from(giftFlower))
                .collect(Collectors.toList());
    }
}
