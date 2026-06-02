package com.ijse.aad1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long studentId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    @ManyToOne // Many students can belong to one school
    private School school;

}
