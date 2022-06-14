package com.twoCube.gifts.dto.detail;

import com.twoCube.gifts.domain.GiftPolaroid;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserPolaroidResponse {

    private String giftPolaroidImage;
    private LocalDate createdAt;
    private String userNickName;
    private Long giftPolaroidId;
    private long polaroidId;
    private String comment;

    public static UserPolaroidResponse from(GiftPolaroid giftPolaroid) {

        return UserPolaroidResponse.builder()
                .giftPolaroidImage(giftPolaroid.getPolaroid())
                .polaroidId(giftPolaroid.getId())
                .giftPolaroidId(giftPolaroid.getId())
                .userNickName(giftPolaroid.getMember().getNickName())
                .comment(giftPolaroid.getComment())
                .createdAt(giftPolaroid.getCreatedAt().toLocalDate())
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
