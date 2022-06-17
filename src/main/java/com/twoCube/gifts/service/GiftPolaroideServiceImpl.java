package com.twoCube.gifts.service;

import com.twoCube.common.EBucketType;
import com.twoCube.common.S3Uploader;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.dto.list.GiftPolaroidResponse;
import com.twoCube.gifts.dto.detail.UserPolaroidResponse;
import com.twoCube.gifts.repository.GiftPolaroidRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
            String imageUrl = s3Uploader.multipartFileUpload(polaroid, EBucketType.polaroid);
            giftPolaroid = GiftPolaroid.builder().comment(comment).couple(couple)
                    .member(member).polaroid(imageUrl).build();

            giftPolaroidRepository.save(giftPolaroid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return giftPolaroid.getId();
    }

    @Override
    public List<GiftPolaroidResponse> getPolaroidList(Member member) {
        List<GiftPolaroid> giftPolaroidList =
                giftPolaroidRepository.findAllByCouple(member.getCouple());
        return GiftPolaroidResponse.listFrom(giftPolaroidList);
    }

    @Override
    public UserPolaroidResponse getPolaroid(Long id) {
        GiftPolaroid giftPolaroid =
                giftPolaroidRepository.getById(id);
        return UserPolaroidResponse.from(giftPolaroid);
    }
}

