package com.twoCube.gifts.dto.request;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.EGiftColor;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.members.domain.Member;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.Random;

@Getter
public class NoteRequest {

    @ApiModelProperty(value = "쪽지 내용", example =
                    "재헌!" +
                    "바쁘다고 밥거르지 말구 잘 챙겨먹어 :)" +
                    "오늘은 날씨가 좀 춥다니까 따뜻하게 입고가구..")
    private String content;

    public GiftNote toEntity(Member member, Couple couple) {
        int pick = new Random().nextInt(EGiftColor.values().length);
        return GiftNote.builder().couple(couple).member(member).content(content).color(EGiftColor.values()[pick]).build();
    }
}
