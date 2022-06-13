package com.twoCube.gifts.service;

import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface GiftPolaroidService {
    Long createPolaroid(MultipartFile polaroid, String content, Member member);
}
