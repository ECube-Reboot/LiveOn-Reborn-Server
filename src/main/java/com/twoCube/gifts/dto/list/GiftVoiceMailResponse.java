package com.twoCube.gifts.dto.list;

import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.domain.GiftVoicemail;
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
//    private String giftVoiceMail;
    private String title;
    private String createdAt;
    private String userNickName;

    public static GiftVoiceMailResponse from(GiftVoicemail giftVoiceMail) {
        DateFormat formatter = new SimpleDateFormat("yyMMdd");

        return GiftVoiceMailResponse.builder()
                .giftVoiceMailId(giftVoiceMail.getId())
                .title(giftVoiceMail.getTitle())
                .createdAt(giftVoiceMail.getCreatedAt()
                        .format(DateTimeFormatter.ofPattern("yyMMdd")))
                .userNickName(giftVoiceMail.getMember().getNickName())
                .build();
    }

    public static List<GiftVoiceMailResponse> listFrom(List<GiftVoicemail> giftVoicemailList) {
        return giftVoicemailList.stream()
                .map(GiftVoiceMailResponse::from)
                .collect(Collectors.toList());
    }
}
