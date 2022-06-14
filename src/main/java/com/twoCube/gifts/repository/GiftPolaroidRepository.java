package com.twoCube.gifts.repository;

import com.sun.xml.bind.v2.runtime.output.C14nXmlOutput;
import com.twoCube.couple.domain.Couple;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPolaroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GiftPolaroidRepository extends JpaRepository<GiftPolaroid, Long> {
    List<GiftPolaroid> findAllByCreatedAtGreaterThanAndCreatedAtLessThanAndCouple(LocalDateTime start, LocalDateTime end, Couple couple);
    List<GiftPolaroid> findAllByCouple(Couple couple);
}
