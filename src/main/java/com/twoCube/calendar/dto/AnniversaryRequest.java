package com.twoCube.calendar.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AnniversaryRequest {
    private LocalDate upcomingEventdate;
    private String upcomingEventTitle;
    private String upcomingEventMemo;
}
