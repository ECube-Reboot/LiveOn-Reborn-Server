package com.twoCube.gifts.dto;

import com.twoCube.gifts.domain.EPillType;
import lombok.Getter;

@Getter
public class PillListResponse {
    private long pillId;
    private EPillType pillType;
    private String pillImage;
}
