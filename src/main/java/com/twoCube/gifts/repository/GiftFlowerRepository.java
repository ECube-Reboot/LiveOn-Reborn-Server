package com.twoCube.gifts.repository;

import com.twoCube.calendar.domain.Event;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GiftFlowerRepository extends JpaRepository<GiftFlower, Long> {
    List<GiftFlower> findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(LocalDateTime start, LocalDateTime end, Couple couple);
}
