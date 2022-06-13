package com.twoCube.calendar.service;

import com.twoCube.calendar.dto.CalendarResponse;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CalendarService {
    CalendarResponse getCalendar(Member member);
}
