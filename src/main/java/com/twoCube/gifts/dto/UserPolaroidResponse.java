package com.twoCube.gifts.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.dto.EventResponse;
import com.twoCube.gifts.domain.GiftPolaroid;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserPolaroidResponse {
    private String polaroidImage;
    private long polaroidId;
    private String comment;

    public static UserPolaroidResponse from(GiftPolaroid giftPolaroid) {

        return UserPolaroidResponse.builder()
                .polaroidImage(giftPolaroid.getPolaroid())
                .polaroidId(giftPolaroid.getId())
                .comment(giftPolaroid.getComment())
                .build();
    }

    public static List<UserPolaroidResponse> listFrom(List<GiftPolaroid> giftPolaroids) {
        if(giftPolaroids == null){
            return null;
        }
        return  giftPolaroids.stream()
                .map(giftPolaroid -> from(giftPolaroid))
                .collect(Collectors.toList());
    }
}
