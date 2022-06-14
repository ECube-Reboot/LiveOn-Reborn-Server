package com.twoCube.calendar.controller;

import com.twoCube.calendar.dto.AnniversaryRequest;

import com.twoCube.calendar.dto.CalendarRequest;
import com.twoCube.calendar.dto.CalendarResponse;
import com.twoCube.calendar.dto.DayRequestDto;
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

@RestController
@RequestMapping("/api/v1/calendar")
@RequiredArgsConstructor
@Api(tags = {"캘린더 API"})
public class CalendarController {

    private final CalendarService calendarService;

    @PostMapping("")
    @ApiOperation(value = "기념일 생성하기 api")
    public ResponseEntity<Long> createNote(@RequestBody AnniversaryRequest anniversaryRequest,
                                           @ApiIgnore @CurrentUser Member member
    ) {
        Long eventId = calendarService.addEvent(anniversaryRequest, member);
        return ResponseEntity.ok(eventId);
    }

    @GetMapping("/day")
    @ApiOperation(value = "하루 보기 api")
    public ResponseEntity<DayRequestDto> getDayGift(
//                                           @ApiIgnore @CurrentUser User user
    ) {
        DayRequestDto dayRequest = new DayRequestDto();
        return ResponseEntity.ok(dayRequest);
    }

    @GetMapping("")
    @ApiOperation(value = "캘린더 메인 api")
    public ResponseEntity<CalendarResponse> getCalendar(@ApiIgnore @CurrentUser Member member,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate calendarRequest
                                                        ) {
        CalendarResponse calendarResponseDto = calendarService.getCalendar(member, calendarRequest);
        return ResponseEntity.ok(calendarResponseDto);
    }

}
