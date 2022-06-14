package com.twoCube.gifts.dto.detail;

import com.twoCube.gifts.domain.GiftNote;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserNoteResponse {

    private LocalDate createdAt;
    private String content;
    private long noteId;
    private String senderName;

    public static UserNoteResponse from(GiftNote giftNote) {

        return UserNoteResponse.builder()
                .content(giftNote.getContent())
                .createdAt(giftNote.getCreatedAt().toLocalDate())
                .noteId(giftNote.getId())
                .senderName(giftNote.getMember().getNickName())
                .build();
    }

    public static List<UserNoteResponse> listFrom(List<GiftNote> giftNotes) {
        if(giftNotes == null){
            return null;
        }
        return  giftNotes.stream()
                .map(giftNote -> from(giftNote))
                .collect(Collectors.toList());
    }
}
