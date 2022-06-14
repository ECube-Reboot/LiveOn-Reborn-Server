package com.twoCube.gifts.repository;

import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPolaroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GiftPolaroidRepository extends JpaRepository<GiftPolaroid, Long> {
    List<GiftPolaroid> findAllByCreatedAtGreaterThanAndCreatedAtLessThan(LocalDateTime start, LocalDateTime end);
}
