package com.twoCube.members.service;

import com.twoCube.members.domain.Member;
import com.twoCube.members.dto.MemberInfoRequest;
import com.twoCube.members.dto.ProfileRequest;
import com.twoCube.members.dto.ProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface MemberService  {
    Long updateMemberInfo(Member member, MemberInfoRequest memberInfoRequest);
    ProfileResponse getProfile(Member member);
    ProfileResponse updateProfile(Member member, ProfileRequest profileRequest);
}
