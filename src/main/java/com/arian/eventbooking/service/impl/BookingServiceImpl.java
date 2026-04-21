package com.arian.eventbooking.service.impl;

import com.arian.eventbooking.entity.AppUser;
import com.arian.eventbooking.entity.Booking;
import com.arian.eventbooking.entity.Event;
import com.arian.eventbooking.exception.InsufficientSeatsException;
import com.arian.eventbooking.exception.ResourceNotFoundException;
import com.arian.eventbooking.repository.AppUserRepository;
import com.arian.eventbooking.repository.BookingRepository;
import com.arian.eventbooking.repository.EventRepository;
import com.arian.eventbooking.service.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;
    private final AppUserRepository appUserRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              EventRepository eventRepository,
                              AppUserRepository appUserRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    @Transactional
    public Booking createBooking(Long userId, Long eventId, int ticketCount) {

        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

         Event event = eventRepository.findById(eventId)
                 .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

         if (event.getAvailableSeats() <ticketCount) {
             throw new InsufficientSeatsException("Not enough seats available");
         }

         event.bookSeats(ticketCount);

         Booking booking = new Booking();
         booking.setUser(user);
         booking.setEvent(event);
         booking.setTicketCount(ticketCount);
         booking.setBookingTime(LocalDateTime.now());

        eventRepository.save(event);
        return bookingRepository.save(booking);

    }

    @Override
    @Transactional
    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        Event event = booking.getEvent();
        event.releaseSeats(booking.getTicketCount());

        eventRepository.save(event);
        bookingRepository.delete(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
