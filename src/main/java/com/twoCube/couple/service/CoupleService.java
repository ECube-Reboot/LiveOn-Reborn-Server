package com.twoCube.couple.service;

import com.twoCube.couple.dto.Code;
import com.twoCube.members.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface CoupleService {
    Code generateCode(Member member);
}
