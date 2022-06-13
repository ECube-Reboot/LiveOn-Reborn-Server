package com.twoCube.gifts.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
public class GiftPill extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private boolean userChecked;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="couple_id")
    private Couple couple;

    @ManyToOne
    @JoinColumn(name="pill_id")
    private Pill pill;
}
