package com.twoCube.gifts.repository;

import com.twoCube.gifts.domain.GiftPill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftPillRepository extends JpaRepository<GiftPill, Long> {
}
