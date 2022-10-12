package com.twoCube.members.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ProfileResponse {
    private String currentUserName;
    private String partnerName;
    private LocalDate officialDate;

    public ProfileResponse(Member currentUser, List<Member> partner, LocalDate firstDay) {
        this.currentUserName = currentUser.getNickName();
        this.currentUserName = currentUser.getNickName();
        if(partner.size() != 0){
            this.partnerName = partner.get(0).getNickName();
        }
        this.officialDate = firstDay;
    }
}
