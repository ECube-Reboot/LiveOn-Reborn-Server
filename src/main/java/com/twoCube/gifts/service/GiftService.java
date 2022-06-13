package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.*;
import com.twoCube.members.domain.Member;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GiftService {
    Long createNote(NoteRequest noteRequest, Member member);
    FlowerResponse getRandomFlower(Member member);
    Long createFlower(FlowerRequest flowerRequest, Member member);
    List<PillListResponse> getPillList();
    Long createPill(PillRequest pillRequest, Member member);
    Long createPolaroid(MultipartFile polaroid, String content, Member member);
}
