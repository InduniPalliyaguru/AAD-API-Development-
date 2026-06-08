package com.ijse.aad1.controller;


import com.ijse.aad1.dto.UserDTO;
import com.ijse.aad1.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "v1/users") // http://localhost:8080/v1/users - base URL for user-related endpoints
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8080/v1/users - POST request to create a new user and specify that the response will be in JSON format
    public UserDTO saveUser(@RequestBody UserDTO userDTO) { // @RequestBody annotation is used to bind the incoming JSON request body to the UserDTO object
        UserDTO savedUser = userService.saveUser(userDTO);
        return savedUser;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8080/v1/users/all - GET request to retrieve all users and specify that the response will be in JSON format
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = userService.getUsers();
        return userDTOList;
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8080/v1/users/{userId} - GET request to retrieve a specific user by their ID and specify that the response will be in JSON format
    public UserDTO getUserDetails(@PathVariable long userId) { // @PathVariable annotation is used to bind the userId path variable from the URL to the method parameter
        UserDTO userDTO = userService.getUserDetail(userId);
        return userDTO;
    }

    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE)// http://localhost:8080/v1/users - PUT request to update an existing user and specify that the response will be in JSON format
    public UserDTO updateUser(@RequestBody UserDTO userDTO) { // @RequestBody annotation is used to bind the incoming JSON request body to the UserDTO object
        return userService.updateUser(userDTO);
    }

    @PatchMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUserStatus(@RequestBody UserDTO userDTO) {
        userService.updateUserStatus(userDTO);
        return "User Status Update Successfully";
    }

    @DeleteMapping (value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return "User Deleted Successfully";
    }

    @GetMapping (value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> filterUsers(@RequestParam (value = "firstName", required = false) String firstName,
                                     @RequestParam (value = "lastName", required = false) String lastName) { // @RequestParam annotation is used to bind the name query parameter from the URL to the method parameter
        // required - false means that the userName parameter is optional, and the method can be called without providing it. If the parameter is not provided, it will be null.

       return userService.filterUsers(firstName, lastName);

    }

}
