package com.twoCube.gifts.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.dto.EventResponse;
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
    private String senderName;
    private LocalDate sentDate;

    public static UserFlowerResponse from(GiftFlower giftFlower) {

        return UserFlowerResponse.builder()
                .userSentFlowerId(giftFlower.getId())
                .message(giftFlower.getMessage())
                .flowerImage(giftFlower.getFlower().getImage())
                .sentDate(giftFlower.getCreatedAt().toLocalDate())
                .build();
    }

    public static List<UserFlowerResponse> listFrom(List<GiftFlower> giftFlowers) {
        if(giftFlowers == null){
            return null;
        }
        return  giftFlowers.stream()
                .map(giftFlower -> from(giftFlower))
                .collect(Collectors.toList());
    }
}
