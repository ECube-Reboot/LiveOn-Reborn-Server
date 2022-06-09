package com.twoCube.calendar.dto;

import com.twoCube.gifts.dto.*;

import java.time.LocalDate;
import java.util.List;

public class DayRequest {
    private LocalDate selectedDate;
    private String message;

    private List<UserAudioResponse> audioResponseList;
    private List<UserPolaroidResponse> polaroidResponseList;
    private List<UserNoteResponse> noteResponseList;
    private List<UserFlowerResponse> flowerResponseList;
    private List<UserPillResponse> pillResponseList;

}
