package com.arian.eventbooking.repository;

import com.arian.eventbooking.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
