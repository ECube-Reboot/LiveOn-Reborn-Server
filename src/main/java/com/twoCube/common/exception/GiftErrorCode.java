package com.twoCube.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
public enum GiftErrorCode implements ErrorCode {
    GIFT_ALREADY_SENT(BAD_REQUEST, "선물은 하루에 한번만 보낼 수 있습니다.");
    private final HttpStatus status;
    private final String message;
}