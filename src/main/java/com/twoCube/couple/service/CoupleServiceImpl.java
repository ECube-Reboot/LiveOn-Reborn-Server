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
public class CoupleServiceImpl implements CoupleService {
    private final CoupleRepository coupleRepository;
    private final MemberRepository memberRepository;

    @Override
    public Code generateCode(Member member) {

        Couple couple = new Couple();
        couple.setCode(RandomStringUtils.randomAlphanumeric(5));
        coupleRepository.save(couple);

        member.setCouple(couple);
        memberRepository.save(member);

        return new Code(couple.getCode());
    }

    @Override
    public String validateCode(Code code, Member member) {

        System.out.println("code:" + code.getCode());

        Couple couple = coupleRepository.findByCode(code.getCode());

        if (couple == null) {
            return "fail: code does Not Exist";
        }
        if (memberRepository.countByCouple(couple) > 2) {
            return "fail: max num for couple is 2";
        }

        member.setCouple(couple);
        memberRepository.save(member);
        return "success";
    }
}
