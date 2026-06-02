package com.ijse.aad1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schoolId;
    private String schoolName;
    private String location;

    @OneToMany (mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // One school can have many students. The mappedBy attribute specifies that the relationship is mapped by the "school" field in the Student entity. The cascade attribute specifies that any operations performed on the School entity (such as saving or deleting) will also be cascaded to the associated Student entities. The fetch attribute specifies that the associated Student entities should be loaded lazily, meaning they will only be loaded when accessed.
    List<Student> students; // This field represents the list of students associated with the school. The @OneToMany annotation indicates that there is a one-to-many relationship between the School entity and the Student entity. Each school can have multiple students, but each student belongs to only one school.

}
