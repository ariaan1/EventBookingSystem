package com.arian.eventbooking.controller;

import com.arian.eventbooking.dto.EventRequest;
import com.arian.eventbooking.dto.EventResponse;
import com.arian.eventbooking.entity.Event;
import com.arian.eventbooking.service.EventService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Placeholder controller for event endpoints.
 */
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventResponse createEvent(@Valid @RequestBody EventRequest request) {
        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setCapacity(request.getCapacity());
        event.setPrice(request.getPrice());


        Event savedEvent = eventService.createEvent(event);

        return mapToResponse(savedEvent);

    }

    @GetMapping
    public List<EventResponse> getAllEvents() {
        return eventService.getAllEvents()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EventResponse getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return mapToResponse(event);
    }

    private EventResponse mapToResponse(Event event) {
        EventResponse response = new EventResponse();
        response.setId(event.getId());
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setLocation(event.getLocation());
        response.setEventDate(event.getEventDate());
        response.setCapacity(event.getCapacity());
        response.setAvailableSeats(event.getAvailableSeats());
        response.setPrice(event.getPrice());
        return response;
    }

    @PutMapping("/{id}")
    public EventResponse updateEvent(@PathVariable Long id,
                                     @Valid @RequestBody EventRequest request) {
        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setCapacity(request.getCapacity());
        event.setPrice(request.getPrice());

        Event updatedEvent = eventService.updateEvent(id, event);

        return mapToResponse(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
