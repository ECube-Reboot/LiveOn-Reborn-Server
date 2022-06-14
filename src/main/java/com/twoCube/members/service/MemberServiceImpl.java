package com.twoCube.members.service;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.members.domain.Member;
import com.twoCube.members.dto.MemberInfoRequest;
import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;

    @Override
    public Long updateMemberInfo(Member member, MemberInfoRequest memberInfoRequest) {
        member.setNickName(memberInfoRequest.getNickName());
        memberRepository.save(member);
        Event birthDay = Event.builder().eventDate(memberInfoRequest.getBirthDay()).couple(member.getCouple()).memo("생일축하드려요").name(member.getNickName() + "생일").build();
        Event officialDay = Event.builder().eventDate(memberInfoRequest.getBirthDay()).couple(member.getCouple()).memo("축하메시지를 남겨주세요").name("처음 사귄 날").build();
        eventRepository.save(birthDay);
        eventRepository.save(officialDay);
        return member.getCouple().getId();
    }
}
