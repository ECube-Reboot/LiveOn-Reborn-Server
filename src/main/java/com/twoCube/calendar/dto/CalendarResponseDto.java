package com.twoCube.calendar.dto;

import com.twoCube.gifts.dto.*;
import lombok.Getter;

import java.util.List;

@Getter
public class CalendarResponseDto {
    private List<EventResponse> eventResponseList;
    private List<UserAudioResponse> audioResponseList;
    private List<UserPolaroidResponse> polaroidResponseList;
    private List<UserNoteResponse> noteResponseList;
    private List<UserFlowerResponse> flowerResponseList;
    private List<UserPillResponse> pillResponseList;
}
