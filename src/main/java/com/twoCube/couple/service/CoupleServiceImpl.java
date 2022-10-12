package com.twoCube.couple.service;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.couple.domain.Couple;
import com.twoCube.couple.dto.Code;
import com.twoCube.couple.dto.OfficialDateRequest;
import com.twoCube.couple.repository.CoupleRepository;
import com.twoCube.members.domain.Member;
import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoupleServiceImpl implements CoupleService {
    private final CoupleRepository coupleRepository;
    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;

    @Override
    public Code generateCode(Member member) {
        Couple couple = new Couple();

        if(member.getCouple() == null){
            couple.setCode(RandomStringUtils.randomAlphanumeric(5));
            coupleRepository.save(couple);
            member.setCouple(couple);
            memberRepository.save(member);
        }

        List<Event> events = eventRepository.findByMember(member);
        events.stream().map(event -> event.setCouple(couple));
        eventRepository.save(Event.builder()
                .eventDate(LocalDate.of(1, 1, 1))
                .couple(member.getCouple()).name("처음 사귄 날").build());

        return new Code(couple.getCode());
    }

    @Override
    @Transactional
    public String validateCode(Code code, Member member) {

        Couple couple = coupleRepository.findByCode(code.getCode());
        List<Event> events = eventRepository.findByMember(member);

        System.out.println(couple.getId());
        if (couple == null) {
            return "fail: code does Not Exist";
        }
        if (memberRepository.countByCouple(couple) > 2) {
            return "fail: max num for couple is 2";
        }

        events.stream().map(event -> event.setCouple(couple));
        member.setCouple(couple);
        memberRepository.save(member);
        return "success";
    }

    @Override
    @Transactional
    public void createOfficialDate(OfficialDateRequest officialDateRequest, Member member) {
        eventRepository.save(Event.builder()
                .eventDate(officialDateRequest.getOfficialDate())
                .couple(member.getCouple()).name("처음 사귄 날").build());
    }

    @Override
    @Transactional
    public void updateOfficialDate(OfficialDateRequest officialDateRequest, Member member) {
        Event event = eventRepository.findByNameAndCouple("처음 사귄 날", member.getCouple())
                .orElseThrow();

        event.changeDate(officialDateRequest.getOfficialDate());
        eventRepository.save(event);
    }
}
