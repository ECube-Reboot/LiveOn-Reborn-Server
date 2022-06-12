package com.twoCube.couple.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
public class Couple extends BaseTimeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private LocalDateTime officialDate;
}
