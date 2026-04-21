package com.arian.eventbooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String location;

    private LocalDateTime eventDate;

    private int capacity;

    private int availableSeats;

    private BigDecimal price;


     public void bookSeats( int ticketCount) {
         if (ticketCount <= 0) {
             throw new RuntimeException("TIcket count must be greater than 0");
         }
         if(this.availableSeats < ticketCount) {
             throw new RuntimeException("Not enough seatis available");
         }
         this.availableSeats -= ticketCount;
     }

     public void releaseSeats(int ticketCount) {
         if (ticketCount <= 0) {
             throw new RuntimeException("Ticket count must be greater than 0");
         }
         this.availableSeats = Math.min(this.capacity, this.availableSeats + ticketCount);
     }
}
