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

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Transient
    private int age;

    //GET used for fields with @Transient annotation because this field is not stored
    public int getAge() {
        return (this.dateOfBirth == null) ? 0 : LocalDate.now().getYear() - dateOfBirth.getYear();
    }


    //TODO:
    // - make this sequence generator to work and increment by 1 not 50 like it is now
    // - store users photo
    // - create RestController for User
    // - write JavaDoc for all
    // - create Account class and connect it with the User
}