package com.arian.eventbooking.service;

import com.arian.eventbooking.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
Booking createBooking (Long userId, Long eventId, int ticketCount);

void deleteBooking(Long bookingId);

    Booking getBookingById(Long bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByUserId(Long userId);
}
