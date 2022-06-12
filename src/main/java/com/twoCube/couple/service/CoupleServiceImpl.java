package com.twoCube.couple.service;

import com.twoCube.couple.domain.Couple;
import com.twoCube.couple.dto.Code;
import com.twoCube.couple.repository.CoupleRepository;
import com.twoCube.members.domain.Member;
import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoupleServiceImpl implements CoupleService{
    private final CoupleRepository coupleRepository;
    private final MemberRepository memberRepository;

    @Override
    public Code generateCode(Member member) {

        Couple couple = Couple.builder().code(RandomStringUtils.randomAlphanumeric(5)).build();
        coupleRepository.save(couple);
        member.setCouple(couple);
        memberRepository.save(member);

        return new Code(couple.getCode());
    }
}
