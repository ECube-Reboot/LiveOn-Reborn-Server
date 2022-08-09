package com.twoCube.calendar.dto;

import com.twoCube.gifts.dto.detail.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class DayRequestDto {
    private LocalDate selectedDate;
    private String message;

    private List<UserAudioResponse> audioResponseList;
    private List<UserPolaroidResponse> polaroidResponseList;
    private List<UserNoteResponse> noteResponseList;
    private List<UserFlowerResponse> flowerResponseList;

}
