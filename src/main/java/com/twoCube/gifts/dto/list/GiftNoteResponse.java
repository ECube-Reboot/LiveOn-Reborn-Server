package com.twoCube.gifts.dto.list;

import com.twoCube.gifts.domain.EGiftColor;
import com.twoCube.gifts.domain.GiftNote;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class GiftNoteResponse {

    private long giftNoteId;
    private String content;
    private LocalDate createdAt;
    private String userNickName;
    private EGiftColor color;

    public static GiftNoteResponse from(GiftNote giftNote) {
        return GiftNoteResponse.builder()
                .giftNoteId(giftNote.getId())
                .content(giftNote.getContent())
                .createdAt(giftNote.getCreatedAt().toLocalDate())
                .userNickName(giftNote.getMember().getNickName())
                .color(giftNote.getColor())
                .build();
    }

    public static List<GiftNoteResponse> listFrom(List<GiftNote> giftNoteList) {
        return giftNoteList.stream()
                .map(GiftNoteResponse::from)
                .collect(Collectors.toList());
    }
}
