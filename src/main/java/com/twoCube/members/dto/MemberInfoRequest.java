package com.twoCube.members.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberInfoRequest {
    private String nickName;
    private LocalDate birthDay;
    private LocalDate officialDate;
}
