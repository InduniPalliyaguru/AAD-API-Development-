package com.ijse.aad1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
