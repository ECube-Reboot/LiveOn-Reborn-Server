package com.twoCube.gifts.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
public class GiftFlower extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String message;

    private boolean userChecked;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="couple_id")
    private Couple couple;

    @ManyToOne
    @JoinColumn(name="flower_id")
    private Flower flower;
}
