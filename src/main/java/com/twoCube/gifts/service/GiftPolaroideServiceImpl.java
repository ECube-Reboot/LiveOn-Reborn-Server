package com.twoCube.gifts.service;

import com.twoCube.common.S3Uploader;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.repository.GiftPolaroidRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GiftPolaroideServiceImpl implements GiftPolaroidService {
    private final S3Uploader s3Uploader;
    private final GiftPolaroidRepository giftPolaroidRepository;


    @Override
    public Long createPolaroid(MultipartFile polaroid, String comment, Member member) {
        Couple couple = member.getCouple();
        GiftPolaroid giftPolaroid = null;
        try {
            String imageUrl = s3Uploader.upload(polaroid);
            giftPolaroid = GiftPolaroid.builder().comment(comment).couple(couple)
                    .member(member).polaroid(imageUrl).build();

            giftPolaroidRepository.save(giftPolaroid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return giftPolaroid.getId();
    }
}
