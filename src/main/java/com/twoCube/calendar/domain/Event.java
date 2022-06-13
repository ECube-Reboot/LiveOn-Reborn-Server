package com.twoCube.calendar.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;

import javax.persistence.*;
import java.time.LocalDate;

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
}
