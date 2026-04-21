package com.arian.eventbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private long id;
    private String fullName;
    private String email;
    private String role;
    private String message;
}
