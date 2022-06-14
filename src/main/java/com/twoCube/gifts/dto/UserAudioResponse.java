package com.twoCube.gifts.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.calendar.dto.EventResponse;
import com.twoCube.gifts.domain.GiftVoicemail;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserAudioResponse {
    private String voiceMail;
    private String title;
    private long voiceMailId;

    public static UserAudioResponse from(GiftVoicemail giftVoicemail) {

        return UserAudioResponse.builder()
                .voiceMailId(giftVoicemail.getId())
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
