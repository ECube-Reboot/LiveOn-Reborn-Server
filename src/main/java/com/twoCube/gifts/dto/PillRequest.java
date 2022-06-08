package com.twoCube.gifts.dto;

import com.twoCube.gifts.domain.EPillType;
import lombok.Getter;

@Getter
public class PillRequest {
    private long pillId;
    private String pillName;
    private String pillEffect;
}
