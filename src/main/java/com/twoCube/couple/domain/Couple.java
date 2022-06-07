package com.twoCube.couple.domain;

import com.twoCube.common.domain.BaseTimeEntity;

import java.time.LocalDateTime;

public class Couple extends BaseTimeEntity {

    private long id;

    private String code;

    private LocalDateTime officialDate;
}
