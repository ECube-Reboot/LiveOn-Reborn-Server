package com.twoCube.members.service;

import com.twoCube.members.domain.Member;
import com.twoCube.members.dto.MemberInfoRequest;
import org.springframework.stereotype.Service;

@Service
public interface MemberService  {
    Long updateMemberInfo(Member member, MemberInfoRequest memberInfoRequest);
}
