package com.ijse.aad1.repository;

import com.ijse.aad1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Mark this interface as a Spring Data repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Extend JpaRepository to provide CRUD operations for User entities
    // No need to write any code here, Spring Data JPA will generate the implementation at runtime
}
