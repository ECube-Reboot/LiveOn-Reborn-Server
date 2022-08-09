package com.twoCube.members.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    private String nickName;

    private String name;

    private String socialId;

    @ManyToOne
    @JoinColumn(name="couple_id")
    private Couple couple;

    @Builder
    public Member(String socialId,  UUID id, String nickName) {
        this.socialId = socialId;
        this.id = id;
        this.nickName = nickName;
    }

}
