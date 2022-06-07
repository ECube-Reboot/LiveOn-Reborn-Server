package com.twoCube.gifts.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.lang.reflect.Member;

public class Gift extends BaseTimeEntity {
    private long id;
    private long gift_id;
    private EGiftType giftType;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="couple_id")
    private Couple couple;
}
