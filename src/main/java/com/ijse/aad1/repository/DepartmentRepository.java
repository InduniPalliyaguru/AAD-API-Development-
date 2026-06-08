package com.ijse.aad1.repository;

import com.ijse.aad1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // This interface extends JpaRepository, which provides CRUD operations for the Department entity.
    // The first generic parameter is the type of the entity (Department), and the second generic parameter is the type of the primary key (Long).

    // Custom query to filter departments based on name and location. The query uses native SQL and allows for optional filtering by name and location.
    @Query (value = "SELECT * FROM department WHERE (?1 IS NULL OR department_name LIKE %?1%) AND (?2 IS NULL OR department_location LIKE %?2%)", nativeQuery = true)
    List<Department> filterDepartments(String name, String location);
}
