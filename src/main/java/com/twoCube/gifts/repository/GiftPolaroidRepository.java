package com.twoCube.gifts.repository;

import com.twoCube.gifts.domain.GiftPolaroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftPolaroidRepository extends JpaRepository<GiftPolaroid, Long> {
}
