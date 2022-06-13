package com.twoCube.gifts.service;

import com.twoCube.members.domain.Member;
import org.springframework.web.multipart.MultipartFile;

public interface GiftVoiceMailService {
    Long createVoicemail(MultipartFile voicemail, String title, Member member);
}
