package com.twoCube.couple.repository;

import com.twoCube.couple.domain.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {
}
