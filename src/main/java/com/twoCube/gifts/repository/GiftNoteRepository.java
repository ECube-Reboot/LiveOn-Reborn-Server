package com.twoCube.gifts.repository;

import com.twoCube.calendar.domain.Event;
import com.twoCube.gifts.domain.GiftNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GiftNoteRepository extends JpaRepository<GiftNote, Long> {
    List<GiftNote> findAllByCreatedAtGreaterThanAndCreatedAtLessThan(LocalDateTime start, LocalDateTime end);
}
