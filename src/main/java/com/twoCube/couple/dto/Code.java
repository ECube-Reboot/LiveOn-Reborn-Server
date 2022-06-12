package com.twoCube.couple.dto;

import lombok.Builder;
import org.apache.commons.lang3.RandomStringUtils;
import lombok.Getter;

@Getter
@Builder
public class Code {
    private String code;

    public Code(String code) {
        this.code = code;
    }
}
