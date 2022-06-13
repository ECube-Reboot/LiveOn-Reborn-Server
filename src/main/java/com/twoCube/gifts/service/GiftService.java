package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.FlowerRequest;
import com.twoCube.gifts.dto.FlowerResponse;
import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.members.domain.Member;

public interface GiftService {
    Long createNote(NoteRequest noteRequest, Member member);
    FlowerResponse getRandomFlower(Member member);
    Long createFlower(FlowerRequest flowerRequest, Member member);
}
