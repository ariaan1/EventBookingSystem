package com.arian.eventbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private Integer ticketCount;

    private LocalDateTime bookingTime;

    public void setTicketCount(Integer ticketCount) {
        if (ticketCount == null || ticketCount <= 0) {
            throw new RuntimeException("Ticket count must be greater than 0");
        }
        this.ticketCount = ticketCount;
    }
}