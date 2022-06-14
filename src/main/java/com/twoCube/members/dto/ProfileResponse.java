package com.twoCube.members.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProfileResponse {
    private String currentUserName;
    private String partnerName;
    private LocalDate officialDate;
}
