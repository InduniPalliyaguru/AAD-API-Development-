package com.ijse.aad1.repository;

import com.ijse.aad1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Mark this interface as a Spring Data repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Extend JpaRepository to provide CRUD operations for User entities
    // No need to write any code here, Spring Data JPA will generate the implementation at runtime

    @Query(value = "SELECT * FROM user WHERE (?1 IS NULL OR first_name Like %?1%) AND (?2 IS NULL OR last_name LIKE %?2%)", nativeQuery = true)
    List<User> filterUsers(String firstName, String lastName);

}
