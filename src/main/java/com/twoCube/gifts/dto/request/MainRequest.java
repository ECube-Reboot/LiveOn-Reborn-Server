package com.twoCube.gifts.dto.request;

import lombok.Getter;

@Getter
public class MainRequest {
    String currentUserName;
    String partner;
    String datedDays;
    boolean hasTape;
    boolean hasFlower;
    boolean hasPhotoBook;
    boolean userGifted;
}
