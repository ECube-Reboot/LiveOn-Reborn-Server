package com.twoCube.calendar.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EventResponse {
    private Long id;
    private String icon;
    private String name;
    private String memo;
    private LocalDate eventDate;
}
