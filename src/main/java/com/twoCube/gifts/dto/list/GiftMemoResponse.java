package com.twoCube.gifts.dto.list;

import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPolaroid;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class GiftMemoResponse {

    private long giftMemoId;
    private String content;
    private LocalDate createdAt;
    private String userNickName;

    public static GiftMemoResponse from(GiftNote giftMemo) {
        return GiftMemoResponse.builder()
                .giftMemoId(giftMemo.getId())
                .content(giftMemo.getContent())
                .createdAt(giftMemo.getCreatedAt().toLocalDate())
                .userNickName(giftMemo.getMember().getNickName())
                .build();
    }

    public static List<GiftMemoResponse> listFrom(List<GiftNote> giftMemoList) {
        return giftMemoList.stream()
                .map(GiftMemoResponse::from)
                .collect(Collectors.toList());
    }
}
