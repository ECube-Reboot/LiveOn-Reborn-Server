package com.twoCube.gifts.dto.detail;

import com.twoCube.gifts.domain.GiftVoicemail;
import com.twoCube.members.domain.Member;
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
    private boolean currentUser;

    public static UserAudioResponse from(GiftVoicemail giftVoicemail, Member member) {

        return UserAudioResponse.builder()
                .createdAt(giftVoicemail.getCreatedAt().toLocalDate())
                .userNickName(giftVoicemail.getMember().getNickName())
                .voiceMailId(giftVoicemail.getId())
                .giftVoiceMailDuration(giftVoicemail.getDuration())
                .title(giftVoicemail.getTitle())
                .voiceMail(giftVoicemail.getVoicemail())
                .currentUser(giftVoicemail.getMember().equals(member))
                .build();
    }

    public static List<UserAudioResponse> listFrom(List<GiftVoicemail> voicemails, Member member) {
        if(voicemails == null){
            return null;
        }
        return  voicemails.stream()
                .map(voicemail -> from(voicemail, member))
                .collect(Collectors.toList());
    }
}
