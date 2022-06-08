package com.twoCube.members.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "USER_ID")
    @Type(type = "uuid-char")
    private UUID id;

    private String nickName;

    private String name;

    private String refreshToken;

    private String birthDay;

    @ManyToOne
    @JoinColumn(name="couple_id")
    private Couple couple;
}
