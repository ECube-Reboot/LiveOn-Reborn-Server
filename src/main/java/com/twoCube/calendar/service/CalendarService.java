package com.twoCube.calendar.service;

import com.twoCube.calendar.dto.AnniversaryRequest;
import com.twoCube.calendar.dto.CalendarRequest;
import com.twoCube.calendar.dto.CalendarResponse;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
public interface CalendarService {
    CalendarResponse getCalendar(Member member, LocalDate calendarRequest);
    Long addEvent(AnniversaryRequest anniversaryRequest, Member member);
}
