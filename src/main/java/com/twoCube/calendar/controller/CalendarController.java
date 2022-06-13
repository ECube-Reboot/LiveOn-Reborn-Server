package com.twoCube.calendar.controller;

import com.twoCube.calendar.dto.AnniversaryRequest;

import com.twoCube.calendar.dto.CalendarResponseDto;
import com.twoCube.calendar.dto.DayRequestDto;
import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/calendar")
@RequiredArgsConstructor
@Api(tags = {"캘린더 API"})
public class CalendarController {

    @PostMapping("")
    @ApiOperation(value = "기념일 생성하기 api")
    public ResponseEntity<Long> createNote(@RequestBody AnniversaryRequest anniversaryRequest
//                                           @ApiIgnore @CurrentUser User user
    ) {
        return ResponseEntity.ok().build();
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
    public ResponseEntity<CalendarResponseDto> getCalendar(@ApiIgnore @CurrentUser Member member
    ) {
        CalendarResponseDto calendarResponseDto = new CalendarResponseDto();
        return ResponseEntity.ok(calendarResponseDto);
    }

}
