package com.roomer.app.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

/**
 * User entity, contains main data about the user
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    /**
     * Unique identifier of the User.
     * Value is generated by the sequence inside the database. (Initial value = 1, Allocation size = 50)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    /**
     * Name of the User
     */
    @Column
    private String name;

    /**
     * Description of the User
     */
    @Column
    private String description;

    /**
     * Date of birth of the user
     */
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    /**
     * Age of the user. (Not stored in database)
     */
    @Transient
    private int age;

    /**
     * Calculates the actual value of the user age.
     * @return age of the user
     */
    //GET used for fields with @Transient annotation because this field is not stored
    public int getAge() {
        return (this.dateOfBirth == null) ? 0 : LocalDate.now().getYear() - dateOfBirth.getYear();
    }


    //TODO:
    // - store users photo
    // - create RestController for User
    // - write JavaDoc
    // - create Account class and connect it with the User
    // - read about HTTP response, headers, status code, body
    // - write tests
}