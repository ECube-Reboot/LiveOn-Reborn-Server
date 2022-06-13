package com.twoCube.gifts.dto;

import com.twoCube.gifts.domain.Pill;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class PillListResponse {
    private long pillId;
    private String pillImage;

    public static PillListResponse from(Pill pill) {

        return PillListResponse.builder()
                .pillId(pill.getId())
                .pillImage(pill.getImage())
                .build();
    }

    public static List<PillListResponse> listFrom(List<Pill> pillList) {
        return pillList.stream()
                .map(PillListResponse::from)
                .collect(Collectors.toList());
    }
}
