package com.twoCube.members.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.UUID;

public class Member extends BaseTimeEntity {

    private UUID id;

    private String nickName;

    private String name;

    private String refreshToken;

    private String birthDay;

    @OneToMany
    @JoinColumn(name="couple_id")
    private Couple couple;
}
