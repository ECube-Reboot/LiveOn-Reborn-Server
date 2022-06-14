package com.twoCube.calendar.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CalendarRequest {
    private LocalDate yearMonth;
}
