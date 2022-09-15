package com.twoCube.calendar.domain;

import com.twoCube.calendar.repository.EventRepository;
import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Event extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate eventDate;

    private String memo;

    private String icon;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    public Event setCouple(Couple couple) {
        this.couple = couple;
        return this;
    }

    public void changeDate(LocalDate newDate) {
        this.eventDate = newDate;
    }
}
