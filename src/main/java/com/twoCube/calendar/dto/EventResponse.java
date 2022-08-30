package com.twoCube.calendar.dto;

import com.twoCube.calendar.domain.Event;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class EventResponse {
    private Long upcomingEventId;
    private String upcomingEventTitle;
    private String upcomingEventMemo;
    private String upcomingEventDate;

    public static EventResponse from(Event event) {

        return EventResponse.builder()
                .upcomingEventId(event.getId())
                .upcomingEventTitle(event.getName())
                .upcomingEventDate(event.getEventDate().toString())
                .upcomingEventMemo(event.getMemo())
                .build();
    }

    public static List<EventResponse> listFrom(List<Event> events) {
        if(events == null){
            return null;
        }
        return  events.stream()
                .map(event -> from(event))
                .collect(Collectors.toList());
    }
}
