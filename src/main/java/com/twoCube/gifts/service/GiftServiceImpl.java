package com.twoCube.gifts.service;

import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.dto.EGiftType;
import com.twoCube.gifts.dto.MainResponse;
import com.twoCube.gifts.repository.GiftFlowerRepository;
import com.twoCube.gifts.repository.GiftNoteRepository;
import com.twoCube.gifts.repository.GiftPolaroidRepository;
import com.twoCube.gifts.repository.GiftVoicemailRepository;
import com.twoCube.members.domain.Member;
import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

    private final EventRepository eventRepository;
    private final GiftFlowerRepository giftFlowerRepository;
    private final GiftPolaroidRepository giftPolaroidRepository;
    private final GiftVoicemailRepository giftVoicemailRepository;
    private final GiftNoteRepository giftNoteRepository;
    private final MemberRepository memberRepository;


    @Override
    public MainResponse getMain(Member member) {
        Couple couple = member.getCouple();
        LocalDate now = LocalDate.now();

        LocalDate officialDate = eventRepository.findByNameAndCouple("처음 사귄 날", member.getCouple())
                .orElseThrow().getEventDate();

        Period period = now.until(now);

        boolean hasFlower = giftFlowerRepository.existsByCouple(couple);
        boolean hasPolaroid = giftPolaroidRepository.existsByCouple(couple);
        boolean hasVoicemail = giftVoicemailRepository.existsByCouple(couple);

        List<EGiftType> nonRecievedGiftType = getUserNotRecievedGiftType(couple);

        List<Member> partner = memberRepository
                .findByCouple(member.getCouple())
                .stream().filter(person -> person != member)
                .collect(Collectors.toList());

        MainResponse mainResponse = MainResponse.builder().currentUserName(member.getNickName())
                .datedDays(period.getDays()).hasFlower(hasFlower).hasPolaroid(hasPolaroid).hasVoicemail(hasVoicemail)
                .userGifted(haveUserGifted(member)).partner(partner.get(0).getNickName())
                .nonCheckedGiftType(nonRecievedGiftType).build();

        return mainResponse;
    }


    private List<EGiftType> getUserNotRecievedGiftType(Couple couple) {
        List<EGiftType> nonRecievedGiftType = new ArrayList<>();
        if (giftFlowerRepository.existsByCoupleAndUserChecked(couple, false)) {
            nonRecievedGiftType.add(EGiftType.flower);
        }
        if (giftNoteRepository.existsByCoupleAndUserChecked(couple, false)) {
            nonRecievedGiftType.add(EGiftType.polaroid);
        }
        if (giftVoicemailRepository.existsByCoupleAndUserChecked(couple, false)) {
            nonRecievedGiftType.add(EGiftType.voicemail);
        }
        return nonRecievedGiftType;
    }

    @Override
    public boolean haveUserGifted(Member member) {
        LocalDateTime startDate = LocalDate.now().atStartOfDay();
        LocalDateTime endDate = LocalDate.now().atTime(LocalTime.MAX);

        if (giftFlowerRepository.existsByCreatedAtGreaterThanAndCreatedAtLessThanAndMember(startDate, endDate, member)) {
            return true;
        }
        if (giftNoteRepository.existsByCreatedAtGreaterThanAndCreatedAtLessThanAndMember(startDate, endDate, member)) {
            return true;
        }
        if (giftVoicemailRepository.existsByCreatedAtGreaterThanAndCreatedAtLessThanAndMember(startDate, endDate, member)) {
            return true;
        }
        if (giftPolaroidRepository.existsByCreatedAtGreaterThanAndCreatedAtLessThanAndMember(startDate, endDate, member)) {
            return true;
        }
        return false;
    }
}

