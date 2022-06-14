package com.twoCube.gifts.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.dto.EventResponse;
import com.twoCube.gifts.domain.GiftNote;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserNoteResponse {
    private String content;
    private long noteId;
    private String senderName;

    public static UserNoteResponse from(GiftNote giftNote) {

        return UserNoteResponse.builder()
                .content(giftNote.getContent())
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
