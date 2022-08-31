package com.twoCube.common.exception;

public class GiftAlreadySentException extends CustomException {
    private static final GiftErrorCode CODE = GiftErrorCode.GIFT_ALREADY_SENT;

    private GiftAlreadySentException(GiftErrorCode errorCode) {
        super(errorCode);
    }

    public GiftAlreadySentException() {
        this(CODE);
    }
}

