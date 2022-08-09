package com.twoCube.gifts.dto.list;

import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.domain.GiftVoicemail;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class GiftVoiceMailResponse {
    private Long giftVoiceMailId;
    private String giftVoiceMailDuration;
    private String title;
    private String createdAt;
    private String userNickName;
    private boolean currentUser;

    public static GiftVoiceMailResponse from(GiftVoicemail giftVoiceMail, Member member) {
        DateFormat formatter = new SimpleDateFormat("yyMMdd");

        return GiftVoiceMailResponse.builder()
                .giftVoiceMailId(giftVoiceMail.getId())
                .title(giftVoiceMail.getTitle())
                .giftVoiceMailDuration(giftVoiceMail.getDuration())
                .createdAt(giftVoiceMail.getCreatedAt()
                        .format(DateTimeFormatter.ofPattern("yyMMdd")))
                .userNickName(giftVoiceMail.getMember().getNickName())
                .currentUser(giftVoiceMail.getMember().equals(member))
                .build();
    }

    public static List<GiftVoiceMailResponse> listFrom(List<GiftVoicemail> giftVoicemailList, Member member) {
        return giftVoicemailList.stream()
                .map(giftVoicemail -> from(giftVoicemail, member))
                .collect(Collectors.toList());
    }
}
