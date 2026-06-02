package com.ijse.aad1.entity;

import com.ijse.aad1.enumeration.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate an all-arguments constructor
@Entity // JPA annotation to mark this class as a database entity
public class User {

    @Id // JPA annotation to mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the primary key value
    private long userId; // Unique identifier for the user
    private String firstName;
    private String lastName;
    private Date dob;
    @Enumerated(EnumType.STRING) // Store the enum as a string in the database
    private UserStatus status;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // One-to-many relationship with UserDepartment
    private List<UserDepartment> userDepartments; // List of UserDepartment entities associated with this user
    // Table -> Class -> Class Annotation -> Entity
    // Column -> Field -> Field Annotation -> Id, GeneratedValue, Enumerated

}
