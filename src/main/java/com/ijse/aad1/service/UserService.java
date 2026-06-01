package com.ijse.aad1.service;

import com.ijse.aad1.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getUsers();

    UserDTO getUserDetail(long userId);

    UserDTO updateUser(UserDTO userDTO);

    void updateUserStatus(UserDTO userDTO);

    void deleteUser(long userId);

}
