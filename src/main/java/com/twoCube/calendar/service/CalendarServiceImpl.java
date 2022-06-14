package com.twoCube.calendar.service;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.dto.CalendarRequest;
import com.twoCube.calendar.dto.CalendarResponse;
import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.*;
import com.twoCube.gifts.repository.*;
import com.twoCube.members.domain.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService{

    private final EventRepository eventRepository;
    private final GiftVoicemailRepository giftVoicemailRepository;
    private final GiftNoteRepository giftNoteRepository;
    private final GiftPolaroidRepository giftPolaroidRepository;
    private final GiftPillRepository giftPillRepository;
    private final GiftFlowerRepository giftFlowerRepository;

    @Override
    public CalendarResponse getCalendar(Member member, LocalDate calendarRequest) {

//        이후 커플제약 걸기
        LocalDate start = calendarRequest.withDayOfMonth(1);
        LocalDateTime startDate = calendarRequest.withDayOfMonth(1).atStartOfDay();
        LocalDate end = calendarRequest.withDayOfMonth(start.lengthOfMonth());
        LocalDateTime endDate = calendarRequest.withDayOfMonth(start.lengthOfMonth()).atTime(LocalTime.MAX);


        List<Event> events = eventRepository.findAllByEventDateGreaterThanAndEventDateLessThanAndCouple(start, end, member.getCouple());
        List<GiftFlower> giftFlowers = giftFlowerRepository.findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(startDate, endDate, member.getCouple());
        List<GiftPill> giftPills = giftPillRepository.findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(startDate, endDate, member.getCouple());
        List<GiftNote> giftNotes = giftNoteRepository.findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(startDate, endDate, member.getCouple());
        List<GiftPolaroid> giftPolaroids = giftPolaroidRepository.findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(startDate, endDate, member.getCouple());
        List<GiftVoicemail> giftVoicemails = giftVoicemailRepository.findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(startDate, endDate, member.getCouple());
        return CalendarResponse.from(events, giftPills,
                giftFlowers, giftPolaroids, giftNotes, giftVoicemails);
    }
}
