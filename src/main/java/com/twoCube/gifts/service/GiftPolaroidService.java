package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.list.GiftPolaroidResponse;
import com.twoCube.gifts.dto.detail.UserPolaroidResponse;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface GiftPolaroidService {
    Long createPolaroid(MultipartFile polaroid, String content, Member member);
    List<GiftPolaroidResponse> getPolaroidList(Member member);
    UserPolaroidResponse getPolaroid(Long id);
}
