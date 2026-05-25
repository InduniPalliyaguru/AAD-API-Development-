package com.ijse.aad1.dto;

import com.ijse.aad1.enumeration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private UserStatus status;
}
