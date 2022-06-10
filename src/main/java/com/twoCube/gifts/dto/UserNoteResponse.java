package com.twoCube.gifts.dto;

import lombok.Getter;

@Getter
public class UserNoteResponse {
    private String content;
    private long noteId;
    private String senderName;
}
