package com.arian.eventbooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BookingResponse {

    private Long id;
    private Long userId;
    private Long eventId;
    private Integer ticketCount;
    private LocalDateTime bookingTime;
}
