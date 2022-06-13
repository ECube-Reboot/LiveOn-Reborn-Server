package com.twoCube.gifts.domain;

import com.twoCube.couple.domain.Couple;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
public class GiftVoicemail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String voicemail;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;
}
