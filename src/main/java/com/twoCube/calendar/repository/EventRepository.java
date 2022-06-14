package com.twoCube.calendar.repository;

import com.twoCube.calendar.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByEventDateGreaterThanAndEventDateLessThan(LocalDate start, LocalDate end);
}
