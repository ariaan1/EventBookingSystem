package com.arian.eventbooking.service.impl;

import com.arian.eventbooking.entity.Event;
import com.arian.eventbooking.exception.ResourceNotFoundException;
import com.arian.eventbooking.repository.EventRepository;
import com.arian.eventbooking.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        event.setAvailableSeats(event.getCapacity());
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public Event updateEvent(Long id, Event updatedevent) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        int bookedSeats = existingEvent.getCapacity() - existingEvent.getAvailableSeats();

        existingEvent.setTitle(updatedevent.getTitle());
        existingEvent.setDescription(updatedevent.getDescription());
        existingEvent.setLocation(updatedevent.getLocation());
        existingEvent.setEventDate(updatedevent.getEventDate());
        existingEvent.setPrice(updatedevent.getPrice());

        existingEvent.setCapacity(updatedevent.getCapacity());
        existingEvent.setAvailableSeats(Math.max(0, updatedevent.getCapacity() - bookedSeats));

        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        eventRepository.delete(event);
    }
}
