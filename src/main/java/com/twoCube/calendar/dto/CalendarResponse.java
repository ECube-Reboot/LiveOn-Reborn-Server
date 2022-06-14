package com.twoCube.calendar.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.gifts.domain.*;
import com.twoCube.gifts.dto.detail.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CalendarResponse {
    private List<EventResponse> eventResponseList;
    private List<UserAudioResponse> audioResponseList;
    private List<UserPolaroidResponse> polaroidResponseList;
    private List<UserNoteResponse> noteResponseList;
    private List<UserFlowerResponse> flowerResponseList;
    private List<UserPillResponse> pillResponseList;


    public static CalendarResponse from(List<Event> events, List<GiftPill> giftPills, List<GiftFlower> giftFlowers, List<GiftPolaroid> giftPolaroids,
                                        List<GiftNote> giftNotes, List<GiftVoicemail> giftVoicemails) {
        return CalendarResponse.builder()
                .eventResponseList(EventResponse.listFrom(events))
                .audioResponseList(UserAudioResponse.listFrom(giftVoicemails))
                .polaroidResponseList(UserPolaroidResponse.listFrom(giftPolaroids))
                .noteResponseList(UserNoteResponse.listFrom(giftNotes))
                .flowerResponseList(UserFlowerResponse.listFrom(giftFlowers))
                .pillResponseList(UserPillResponse.listFrom(giftPills))
                .build();
    }

}
