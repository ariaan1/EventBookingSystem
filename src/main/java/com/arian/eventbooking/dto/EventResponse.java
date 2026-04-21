package com.arian.eventbooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EventResponse {

    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private int capacity;
    private int availableSeats;
    private BigDecimal price;
}
