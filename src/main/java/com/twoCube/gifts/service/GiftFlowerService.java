package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.detail.UserFlowerResponse;
import com.twoCube.gifts.dto.list.GiftFlowerResponse;
import com.twoCube.gifts.dto.request.FlowerRequest;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftFlowerService {

    Long createFlower(FlowerRequest flowerRequest, Member member);

    List<GiftFlowerResponse> getFlowerList(Member member);

    UserFlowerResponse getFlower(Long id);
}
