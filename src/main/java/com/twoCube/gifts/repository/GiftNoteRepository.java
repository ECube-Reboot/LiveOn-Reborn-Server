package com.twoCube.gifts.repository;

import com.twoCube.gifts.domain.GiftNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftNoteRepository extends JpaRepository<GiftNote, Long> {
}
