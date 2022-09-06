package com.twoCube.gifts.repository;

import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.domain.GiftVoicemail;
import com.twoCube.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GiftVoicemailRepository extends JpaRepository<GiftVoicemail, Long> {
    List<GiftVoicemail> findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(LocalDateTime start, LocalDateTime end, Couple couple);

    List<GiftVoicemail> findAllByGiftDateAndCouple(LocalDateTime start, LocalDateTime end, Couple couple);

    List<GiftVoicemail> findAllByCouple(Couple couple);

    Boolean existsByCoupleAndUserChecked(Couple couple, @Param("user_checked") boolean userChecked);

    Boolean existsByCouple(Couple couple);

    Boolean existsByCreatedAtGreaterThanAndCreatedAtLessThanAndMember(LocalDateTime start, LocalDateTime end, Member member);

    @Override
    boolean existsById(Long aLong);
}
