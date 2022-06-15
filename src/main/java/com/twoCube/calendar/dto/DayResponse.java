package com.twoCube.calendar.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.gifts.domain.*;
import com.twoCube.gifts.dto.detail.*;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class DayResponse {

    private EventResponse eventResponse;
    private List<UserAudioResponse> audioResponseList;
    private List<UserPolaroidResponse> polaroidResponseList;
    private List<UserNoteResponse> noteResponseList;
    private List<UserFlowerResponse> flowerResponseList;
    private List<UserPillResponse> pillResponseList;

    public DayResponse(List<Event> eventList, List<GiftVoicemail> giftVoicemailList, List<GiftPolaroid> giftPolaroidList,
                       List<GiftNote> giftNoteList, List<GiftFlower> giftFlowerList, List<GiftPill> giftPillList) {
        this.eventResponse = EventResponse.from(eventList.get(0));
        this.audioResponseList = UserAudioResponse.listFrom(giftVoicemailList);
        this.polaroidResponseList = UserPolaroidResponse.listFrom(giftPolaroidList);
        this.noteResponseList = UserNoteResponse.listFrom(giftNoteList);
        this.flowerResponseList = UserFlowerResponse.listFrom(giftFlowerList);
        this.pillResponseList = UserPillResponse.listFrom(giftPillList);
    }

}
