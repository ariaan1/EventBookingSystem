package com.arian.eventbooking.entity;

import com.arian.eventbooking.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;


}
