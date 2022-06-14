package com.twoCube.calendar.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AnniversaryRequest {
    private LocalDate date;
    private String name;
    private String memo;
    private String icon;
}
