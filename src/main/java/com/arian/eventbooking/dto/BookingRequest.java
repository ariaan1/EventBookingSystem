package com.arian.eventbooking.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookingRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Event ID is required")
    private Long eventId;

    @Positive(message = "Ticket count must be greater than 0")
    private  int ticketCount;

    public Long getUserId() {
        return userId;
    }
    public Long getEventId() {
        return eventId;
    }
    public int getTicketCount() {
        return ticketCount;
    }
}
