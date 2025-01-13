package com.example.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate visitDate;
    private String photoUrl; // Fotoğraf dosyasının yolu

    @ManyToOne
    private Country country;

    @ManyToOne
    private User user; // Hangi hostes bu bilgiyi ekledi

    // Getters, Setters, Constructors
}

