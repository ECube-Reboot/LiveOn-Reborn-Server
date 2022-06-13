package com.twoCube.calendar.repository;

import com.twoCube.calendar.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
