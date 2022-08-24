package com.twoCube.calendar.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.gifts.domain.*;
import com.twoCube.gifts.dto.detail.*;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CalendarResponse {
    private List<EventResponse> eventResponseList;
    private List<MonthResponse> monthResponses;

    public static CalendarResponse from(List<Event> events, List<GiftFlower> giftFlowers, List<GiftPolaroid> giftPolaroids,
                                        List<GiftNote> giftNotes, List<GiftVoicemail> giftVoicemails, Member member) {

            return CalendarResponse.builder()
                    .eventResponseList(EventResponse.listFrom(events))
                    .monthResponses(
                            MonthResponse.listfrom(
                                    giftFlowers, giftPolaroids, giftNotes, giftVoicemails, member))
                    .build();
    }

}
