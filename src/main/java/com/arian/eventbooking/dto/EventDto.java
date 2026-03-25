package com.arian.eventbooking.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {

    private Long id;
    private String title;
    private String location;
    private LocalDateTime eventDate;
    private Integer availableSeats;
}
