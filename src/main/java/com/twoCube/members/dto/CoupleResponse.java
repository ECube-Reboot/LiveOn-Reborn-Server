package com.twoCube.members.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoupleResponse {
    private boolean coupleMatched;
}
