package com.twoCube.members.service;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.members.domain.Member;
import com.twoCube.members.domain.WithdrawlMember;
import com.twoCube.members.dto.MemberInfoRequest;
import com.twoCube.members.dto.ProfileRequest;
import com.twoCube.members.dto.ProfileResponse;
import com.twoCube.members.repository.MemberRepository;
import com.twoCube.members.repository.WithdrawlMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;
    private final WithdrawlMemberRepository withdrawlRepository;

    @Override
    @Transactional
    public Long updateMemberInfo(Member member, MemberInfoRequest memberInfoRequest) {
        member.setNickName(memberInfoRequest.getNickName());
        memberRepository.save(member);
        Event birthDay = Event.builder().eventDate(memberInfoRequest.getBirthDay()).couple(member.getCouple()).memo("생일축하드려요").name(member.getNickName() + "생일").build();
        Event officialDay = Event.builder().eventDate(memberInfoRequest.getBirthDay()).couple(member.getCouple()).memo("축하메시지를 남겨주세요").name("처음 사귄 날").build();
        eventRepository.save(birthDay);
        eventRepository.save(officialDay);
        return member.getCouple().getId();
    }

    @Override
    @Transactional
    public ProfileResponse getProfile(Member member){
        System.out.println(memberRepository.findByCouple(member.getCouple()).size());
        List<Member> partner = memberRepository
                .findByCouple(member.getCouple())
                .stream().filter(person -> person.getId() != member.getId())
                .collect(Collectors.toList());
        System.out.println(partner.size());
        return new ProfileResponse(member, partner.get(0), eventRepository.findByNameAndCouple("처음 사귄 날", member.getCouple()).orElseThrow());
    }

    @Override
    @Transactional
    public ProfileResponse updateProfile(Member member, ProfileRequest profileRequest) {
        member.setNickName(profileRequest.getNickName());
        memberRepository.save(member);
        ProfileResponse profileResponse = getProfile(member);
        return profileResponse;
    }

    @Override
    @Transactional
    public void withdrawlMemberShip(Member member) {
        member.setDeleted(true);
        memberRepository.save(member);
        withdrawlRepository.save(WithdrawlMember.builder().member(member).build());
        return;
    }
}
