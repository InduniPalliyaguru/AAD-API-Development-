package com.ijse.aad1.service.impl;

import com.ijse.aad1.dto.UserDTO;
import com.ijse.aad1.entity.User;
import com.ijse.aad1.enumeration.UserStatus;
import com.ijse.aad1.repository.UserRepository;
import com.ijse.aad1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        log.info("Execute method save user" + userDTO.toString());

        log.info("Saving user to the database...");
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDob(userDTO.getDob());
        user.setStatus(userDTO.getStatus());

        User savedUser = userRepository.save(user);
        UserDTO responseDTO = new UserDTO();
        responseDTO.setUserId(savedUser.getUserId());
        responseDTO.setFirstName(savedUser.getFirstName());
        responseDTO.setLastName(savedUser.getLastName());
        responseDTO.setDob(savedUser.getDob());
        responseDTO.setStatus(savedUser.getStatus());

        return responseDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Execute method get users");

        try {

            List<UserDTO> responseList = new ArrayList<>(); // Create an empty list to hold the UserDTO objects
            List<User> userList = userRepository.findAll(); // Retrieve all User entities from the database using the userRepository's findAll() method

            for (User user : userList) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(user.getUserId());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setLastName(user.getLastName());
                userDTO.setStatus(user.getStatus());

                responseList.add(userDTO);
            }
            return responseList; // Return the list of UserDTO objects as the response

        } catch (Exception e) {
            log.error("Error in method getUser"+ e.getMessage()); // Log the error message if an exception occurs during the execution of the method
            throw e; // Rethrow the exception to be handled by the caller or global exception handler
        }
    }

    @Override
    public UserDTO getUserDetail(long userId) {
        log.info("Execute method get user detail with user id: " + userId);

        try {

            Optional<User> optionalUser = userRepository.findById(userId); // Retrieve a User entity from the database using the userRepository's findById() method, which returns an Optional<User> object
            if (!optionalUser.isPresent()) { // Check if the Optional<User> object does not contain a User entity (i.e., the User entity is not found in the database)
                throw new RuntimeException("User not found with id: " + userId); // Log an error message if the User entity is not found in the database
            }

            User user = optionalUser.get(); // Retrieve the User entity from the Optional<User> object
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setStatus(user.getStatus());

            return dto; // Return the UserDTO object as the response

        } catch (Exception e) {
            log.error("Error in method getUserDetail"+ e.getMessage()); // Log the error message if an exception occurs during the execution of the method
            throw e; // Rethrow the exception to be handled by the caller or global exception handler
        }
    }
}
