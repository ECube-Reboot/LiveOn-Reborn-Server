package com.twoCube.gifts.dto;

import com.twoCube.gifts.domain.Flower;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FlowerResponse {
    private long flowerId;
    private String meaning;
    private String flowerName;
    private String flowerImage;

    public FlowerResponse(Flower flower){
        this.flowerId = flower.getId();
        this.meaning = flower.getDescription();
        this.flowerName = flower.getName();
        this.flowerImage = flower.getImage();
    }
}
