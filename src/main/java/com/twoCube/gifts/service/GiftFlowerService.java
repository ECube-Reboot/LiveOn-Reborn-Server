package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.FlowerRequest;
import com.twoCube.gifts.dto.FlowerResponse;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface GiftFlowerService {
    FlowerResponse getRandomFlower(Member member);
    Long createFlower(FlowerRequest flowerRequest, Member member);
}
