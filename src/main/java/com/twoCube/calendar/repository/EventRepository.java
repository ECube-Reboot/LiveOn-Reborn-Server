package com.twoCube.calendar.repository;

import com.twoCube.calendar.domain.Event;
import com.twoCube.couple.domain.Couple;
import com.twoCube.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByEventDateGreaterThanAndEventDateLessThanAndCouple(LocalDate start, LocalDate end, Couple couple);
    Event findByNameAndCouple(@Param(value = "name") String name, @Param(value="couple")Couple couple);
}
