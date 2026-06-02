package com.ijse.aad1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDepartment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long userDepartmentId;
    @ManyToOne
    private User user;
    // Many UserDepartment entities can be associated with one User entity,
    // indicating that a user can belong to multiple departments.

    @ManyToOne
    private Department department;
    // Many UserDepartment entities can be associated with one Department entity,
    // indicating that a department can have multiple users.

}
