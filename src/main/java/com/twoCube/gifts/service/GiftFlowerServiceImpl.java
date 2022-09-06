package com.twoCube.gifts.service;

import com.twoCube.common.exception.GiftAlreadySentException;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.dto.detail.UserFlowerResponse;
import com.twoCube.gifts.dto.detail.UserNoteResponse;
import com.twoCube.gifts.dto.list.GiftFlowerResponse;
import com.twoCube.gifts.dto.request.FlowerRequest;
import com.twoCube.gifts.repository.GiftFlowerRepository;
import com.twoCube.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftFlowerServiceImpl implements GiftFlowerService {
    private final GiftService giftService;
    private final GiftFlowerRepository giftFlowerRepository;


    @Override
    public Long createFlower(FlowerRequest flowerRequest, Member member) {
        if(giftService.haveUserGifted(member)){
//            throw new GiftAlreadySentException();
        }
        Couple couple = member.getCouple();
        GiftFlower giftFlower = flowerRequest
                .toEntity(member, couple, flowerRequest.getFlowerName());
        giftFlowerRepository.save(giftFlower);
        return giftFlower.getId();
    }

    @Override
    public List<GiftFlowerResponse> getFlowerList(Member member) {
        List<GiftFlower> giftFlowerList =
                giftFlowerRepository.findAllByCouple(member.getCouple());
        return GiftFlowerResponse.listFrom(giftFlowerList);
    }

    @Override
    public UserFlowerResponse getFlower(Long id) {
        GiftFlower giftFlower =
                giftFlowerRepository.getById(id);
        return UserFlowerResponse.from(giftFlower);
    }
}
