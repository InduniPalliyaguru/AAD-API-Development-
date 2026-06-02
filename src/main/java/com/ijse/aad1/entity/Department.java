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
public class Department {

    @Id // Mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the primary key value using the database's identity column
    private long departmentId;
    private String departmentName;
    private String departmentLocation;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // One-to-many relationship with UserDepartment
    List<UserDepartment> userDepartments; // List of UserDepartment entities associated with this department

}
