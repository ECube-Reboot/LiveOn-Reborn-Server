package com.twoCube.gifts.service;

import com.twoCube.gifts.dto.detail.UserAudioResponse;
import com.twoCube.gifts.dto.list.GiftVoiceMailResponse;
import com.twoCube.members.domain.Member;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GiftVoiceMailService {
    Long createVoicemail(MultipartFile voicemail, String title, String voiceMailDuration, Member member);
    List<GiftVoiceMailResponse> getVoiceMailList(Member member);
    UserAudioResponse getVoiceMail(Long id);
}
