package com.twoCube.members.service;

import com.twoCube.members.domain.Member;
import com.twoCube.members.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface MemberService  {
    Long updateMemberInfo(Member member, MemberInfoRequest memberInfoRequest);
    ProfileResponse getProfile(Member member);
    void updateNickname(Member member, NicknameRequest profileRequest);
    void withdrawlMemberShip(Member member);
    void updateBirthday(Member member, BirthdayRequest birthdayRequest);
    void updateOfficialDate(Member member,
                            OfficialDateRequest officialDateRequest);
    CoupleResponse checkIfCouple(Member member);
}
