package com.twoCube.couple.service;

import com.twoCube.couple.dto.Code;
import com.twoCube.couple.dto.OfficialDateRequest;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface CoupleService {
    Code generateCode(Member member);
    String validateCode(Code code, Member member);
    void createOfficialDate(OfficialDateRequest officialDateRequest, Member member);
    void updateOfficialDate(OfficialDateRequest officialDateRequest, Member member);
}
