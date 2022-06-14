package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.PillListResponse;
import com.twoCube.gifts.dto.request.PillRequest;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftPillService {
    List<PillListResponse> getPillList();
    Long createPill(PillRequest pillRequest, Member member);
}
