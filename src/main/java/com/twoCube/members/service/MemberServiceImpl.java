package com.twoCube.members.service;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.couple.domain.Couple;
import com.twoCube.couple.repository.CoupleRepository;
import com.twoCube.members.domain.Member;
import com.twoCube.members.domain.WithdrawlMember;
import com.twoCube.members.dto.*;
import com.twoCube.members.repository.MemberRepository;
import com.twoCube.members.repository.WithdrawlMemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;
    private final WithdrawlMemberRepository withdrawlRepository;
    private final CoupleRepository coupleRepository;

    @Override
    @Transactional
    public void updateMemberInfo(Member member, MemberInfoRequest memberInfoRequest) {


        member.setNickName(memberInfoRequest.getNickName());
        memberRepository.save(member);
        Event birthDay = Event.builder().eventDate(LocalDate.parse(memberInfoRequest.getBirthDay())).memo("생일축하드려요").name(member.getNickName() + "생일").member(member).build();
        eventRepository.save(birthDay);
    }

    @Override
    @Transactional
    public ProfileResponse getProfile(Member member) {
        List<Member> partner = memberRepository
                .findByCouple(member.getCouple())
                .stream().filter(person -> !person.getId().equals(member.getId()))
                .collect(Collectors.toList());
        Optional<Event> event = eventRepository
                .findByNameAndCouple("처음 사귄 날", member.getCouple());
        LocalDate days = LocalDate.of(0, 0, 0);
        if (!event.isEmpty()) {
            days = event.get().getEventDate();
        }
        return new ProfileResponse(member, partner.get(0), days);
    }

    @Override
    @Transactional
    public void updateNickname(Member member, NicknameRequest profileRequest) {
        member.setNickName(profileRequest.getNickName());
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public CoupleResponse checkIfCouple(Member member) {
        Couple couple = member.getCouple();
        if (couple != null || memberRepository.countByCouple(couple) == 2) {
            return CoupleResponse.builder().coupleMatched(true).build();
        } else {
            return CoupleResponse.builder().coupleMatched(false).build();
        }
    }

    @Override
    @Transactional
    public void updateBirthday(Member member, BirthdayRequest birthdayRequest) {
        Event birhday = eventRepository
                .findByNameAndCouple(member.getNickName() + "생일", member.getCouple())
                .orElseThrow();
        birhday.changeDate(birthdayRequest.getBirthDay());
        eventRepository.save(birhday);
    }

    @Override
    @Transactional
    public void withdrawlMemberShip(Member member) {
        member.setDeleted(true);
        member.setSocialId("withdrawledMember");
        memberRepository.save(member);
        withdrawlRepository.save(WithdrawlMember.builder().member(member).build());
        return;
    }
}
