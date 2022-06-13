package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.FlowerRequest;
import com.twoCube.gifts.dto.FlowerResponse;
import com.twoCube.gifts.dto.NoteRequest;
import com.twoCube.gifts.dto.PillListResponse;
import com.twoCube.members.domain.Member;

import java.util.List;

public interface GiftService {
    Long createNote(NoteRequest noteRequest, Member member);
    FlowerResponse getRandomFlower(Member member);
    Long createFlower(FlowerRequest flowerRequest, Member member);
    List<PillListResponse> getPillList();
}
