package com.twoCube.gifts.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserFlowerResponse {
    private long userSentFlowerId;
    private String message;
    private String flowerImage;
    private String senderName;
    private LocalDate sentDate;
}
