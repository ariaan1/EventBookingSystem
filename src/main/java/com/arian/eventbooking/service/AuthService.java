package com.arian.eventbooking.service;

import com.arian.eventbooking.dto.AuthResponse;
import com.arian.eventbooking.dto.LoginRequest;
import com.arian.eventbooking.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
