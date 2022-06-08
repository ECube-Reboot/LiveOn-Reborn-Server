package com.twoCube.gifts.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class NoteRequest {

    @ApiModelProperty(value = "쪽지 내용", example =
                    "재헌!" +
                    "바쁘다고 밥거르지 말구 잘 챙겨먹어 :)" +
                    "오늘은 날씨가 좀 춥다니까 따뜻하게 입고가구..")
    private String content;
}
