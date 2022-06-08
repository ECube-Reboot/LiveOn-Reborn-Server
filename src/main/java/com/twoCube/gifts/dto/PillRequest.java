package com.twoCube.gifts.dto;

import com.twoCube.gifts.domain.EPillType;
import lombok.Getter;

@Getter
public class PillRequest {
    private EPillType pillType;
    private String pillName;
    private String pillEffect;
}
