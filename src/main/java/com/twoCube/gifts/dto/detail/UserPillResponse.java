package com.twoCube.gifts.dto.detail;

import com.twoCube.gifts.domain.GiftPill;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserPillResponse {
    private long userSentPillId;
    private String pillName;
    private String pillEffect;
    private String pillImage;
    private String senderName;
    private LocalDate sentDate;

    public static UserPillResponse from(GiftPill giftPill) {

        return UserPillResponse.builder()
                .userSentPillId(giftPill.getId())
                .pillName(giftPill.getName())
                .pillEffect(giftPill.getDescription())
                .pillImage(giftPill.getPill().getImage())
                .senderName(giftPill.getName())
                .sentDate(giftPill.getCreatedAt().toLocalDate())
                .build();
    }

    public static List<UserPillResponse> listFrom(List<GiftPill> giftPills) {
        if (giftPills == null) {
            return null;
        }
        return giftPills.stream()
                .map(giftPill -> from(giftPill))
                .collect(Collectors.toList());
    }
}
