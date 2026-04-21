package com.arian.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUser extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
