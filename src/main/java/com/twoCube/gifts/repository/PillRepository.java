package com.twoCube.gifts.repository;

import com.twoCube.gifts.domain.Pill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PillRepository extends JpaRepository<Pill, Long> {
}
