package com.twoCube.members.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProfileResponse {
    private String currentUserName;
    private String partnerName;
    private LocalDate officialDate;

    public ProfileResponse(Member currentUser, Member partner, Event firstDay) {
        this.currentUserName = currentUser.getNickName();
        this.currentUserName = currentUser.getNickName();
        this.partnerName = partner.getNickName();
        this.officialDate = firstDay.getEventDate();
    }
}
