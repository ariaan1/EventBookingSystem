package com.arian.eventbooking.service.impl;

import com.arian.eventbooking.dto.AuthResponse;
import com.arian.eventbooking.dto.LoginRequest;
import com.arian.eventbooking.dto.RegisterRequest;
import com.arian.eventbooking.entity.AppUser;
import com.arian.eventbooking.enums.Role;
import com.arian.eventbooking.repository.AppUserRepository;
import com.arian.eventbooking.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AppUserRepository appUserRepository , PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (appUserRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        AppUser user = new AppUser();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));        user.setRole(Role.USER);

        AppUser savedUser = appUserRepository.save(user);

        AuthResponse response = new AuthResponse();
        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole().name());
        response.setMessage("User registered successfully");

        return response;
    }

  @Override
  public AuthResponse login(LoginRequest request) {

        AppUser user = appUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

  if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid password");
  }

        AuthResponse response = new AuthResponse();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setMessage("Login successful");

        return response;
  }

}
