package com.twoCube.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestMultipartDto {
    private String imageName;
    private String contentRecieved;

    public TestMultipartDto(String imageName, String contentRecieved) {
        this.imageName = imageName;
        this.contentRecieved = contentRecieved;
    }
}
