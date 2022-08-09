package com.twoCube.gifts.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MainResponse {
    String currentUserName;
    String partner;
    int datedDays;
    List<EGiftType> nonCheckedGiftType;
    boolean hasVoicemail;
    boolean hasFlower;
    boolean hasPolaroid;
    boolean hasPill;
    boolean userGifted;
}
