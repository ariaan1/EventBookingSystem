package com.arian.eventbooking.service;

import com.arian.eventbooking.entity.Booking;
import com.arian.eventbooking.entity.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Long id);

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);



}
