package com.twoCube.gifts.dto.list;

import com.twoCube.gifts.domain.GiftPolaroid;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class GiftPolaroidResponse {
    private Long giftPolaroidId;
    private String giftPolaroidImage;
    private LocalDate createdAt;
    private String userNickName;
    private String comment;

    public static GiftPolaroidResponse from(GiftPolaroid giftPolaroid) {
        return GiftPolaroidResponse.builder()
                .giftPolaroidId(giftPolaroid.getId())
                .giftPolaroidImage(giftPolaroid.getPolaroid())
                .createdAt(giftPolaroid.getCreatedAt().toLocalDate())
                .userNickName(giftPolaroid.getMember().getNickName())
                .comment(giftPolaroid.getComment())
                .build();
    }

    public static List<GiftPolaroidResponse> listFrom(List<GiftPolaroid> giftPolaroidList) {
        return giftPolaroidList.stream()
                .map(GiftPolaroidResponse::from)
                .collect(Collectors.toList());
    }
}
