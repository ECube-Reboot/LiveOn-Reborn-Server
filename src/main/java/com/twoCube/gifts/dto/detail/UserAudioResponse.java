package com.twoCube.gifts.dto.detail;

import com.twoCube.gifts.domain.GiftVoicemail;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserAudioResponse {
    private String voiceMail;
    private String title;
    private long voiceMailId;
    private LocalDate createdAt;
    private String userNickName;
    private String giftVoiceMailDuration;

    public static UserAudioResponse from(GiftVoicemail giftVoicemail) {

        return UserAudioResponse.builder()
                .createdAt(giftVoicemail.getCreatedAt().toLocalDate())
                .userNickName(giftVoicemail.getMember().getNickName())
                .voiceMailId(giftVoicemail.getId())
                .giftVoiceMailDuration(giftVoicemail.getDuration())
                .title(giftVoicemail.getTitle())
                .voiceMail(giftVoicemail.getVoicemail())
                .build();
    }

    public static List<UserAudioResponse> listFrom(List<GiftVoicemail> voicemails) {
        if(voicemails == null){
            return null;
        }
        return  voicemails.stream()
                .map(voicemail -> from(voicemail))
                .collect(Collectors.toList());
    }
}
