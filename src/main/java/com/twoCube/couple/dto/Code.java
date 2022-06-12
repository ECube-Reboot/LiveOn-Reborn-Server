package com.twoCube.couple.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import lombok.Getter;

@Getter
@NoArgsConstructor
public class Code {
    private String code;

    public Code(String code) {
        this.code = code;
    }
}
