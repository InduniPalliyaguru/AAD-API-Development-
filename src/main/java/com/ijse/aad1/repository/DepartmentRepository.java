package com.ijse.aad1.repository;

import com.ijse.aad1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // This interface extends JpaRepository, which provides CRUD operations for the Department entity.
    // The first generic parameter is the type of the entity (Department), and the second generic parameter is the type of the primary key (Long).
}
