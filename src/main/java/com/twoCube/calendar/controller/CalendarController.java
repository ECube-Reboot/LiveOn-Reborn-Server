package com.twoCube.calendar.controller;

import com.twoCube.calendar.dto.*;

import com.twoCube.calendar.service.CalendarService;
import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.common.reflection.XMember;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/calendar")
@RequiredArgsConstructor
@Api(tags = {"캘린더 API"})
public class CalendarController {

    private final CalendarService calendarService;

    @PostMapping("")
    @ApiOperation(value = "기념일 생성하기 api")
    public ResponseEntity<Long> createEvent(@RequestBody AnniversaryRequest anniversaryRequest,
                                           @ApiIgnore @CurrentUser Member member
    ) {
        Long eventId = calendarService.addEvent(anniversaryRequest, member);
        return ResponseEntity.ok(eventId);
    }

    @DeleteMapping("")
    @ApiOperation(value = "기념일 삭제하기 api")
    public ResponseEntity<Long> createNote(@PathVariable Long eventId,
                                           @ApiIgnore @CurrentUser Member member
    ) {
        calendarService.deleteEvent(eventId, member);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/day")
    @ApiOperation(value = "하루 보기 api")
    public ResponseEntity<DayResponse> getDayGift(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate calendarRequest,
            @ApiIgnore @CurrentUser Member member
    ) {
        DayResponse dayResponse = calendarService.getDay(member,calendarRequest);
        return ResponseEntity.ok(dayResponse);
    }

    @GetMapping("")
    @ApiOperation(value = "캘린더 메인 api")
    public ResponseEntity<CalendarResponse> getCalendar(@ApiIgnore @CurrentUser Member member,
                                                        @RequestParam String calendarRequest
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate requestDate = LocalDate.parse(calendarRequest, formatter);
        CalendarResponse calendarResponseDto = calendarService.getCalendar(member, requestDate);
        return ResponseEntity.ok(calendarResponseDto);
    }

}
