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
    private Long id;
    private String emoji;
    private String eventTitle;
    private String eventMemo;
    private LocalDate eventDate;

    public static EventResponse from(Event event) {

        return EventResponse.builder()
                .id(event.getId())
                .emoji(event.getIcon())
                .eventTitle(event.getName())
                .eventMemo(event.getMemo())
                .eventDate(event.getEventDate())
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
