package com.roomer.app.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String name;

    @Column
    private String description;
    @Transient
    private int age;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    // private photo at some point...
}