package com.twoCube.gifts.repository;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPill;
import com.twoCube.gifts.domain.GiftVoicemail;
import com.twoCube.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GiftPillRepository extends JpaRepository<GiftPill, Long> {
    List<GiftPill> findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(LocalDateTime start, LocalDateTime end, Couple couple);

    Boolean existsByCoupleAndUserChecked(Couple couple, boolean userChecked);

    Boolean existsByCouple(Couple couple);

    Boolean existsByCreatedAtGreaterThanAndCreatedAtLessThanAndMember(LocalDateTime start, LocalDateTime end, Member member);

}
