package com.arian.eventbooking.controller;

import com.arian.eventbooking.dto.BookingRequest;
import com.arian.eventbooking.dto.BookingResponse;
import com.arian.eventbooking.entity.Booking;
import com.arian.eventbooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest request) {
        Booking booking = bookingService.createBooking(
                request.getUserId(),
                request.getEventId(),
                request.getTicketCount()
        );

        BookingResponse response = new BookingResponse();
        response.setId(booking.getId());
        response.setUserId(booking.getUser().getId());
        response.setEventId(booking.getEvent().getId());
        response.setTicketCount(booking.getTicketCount());
        response.setBookingTime(booking.getBookingTime());

        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return mapToResponse(booking);
    }
    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public List<BookingResponse> getAllBookingsByUserId(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private BookingResponse mapToResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setId(booking.getId());
        response.setUserId(booking.getUser().getId());
        response.setEventId(booking.getEvent().getId());
        response.setTicketCount(booking.getTicketCount());
        response.setBookingTime(booking.getBookingTime());
        return response;
    }

}







