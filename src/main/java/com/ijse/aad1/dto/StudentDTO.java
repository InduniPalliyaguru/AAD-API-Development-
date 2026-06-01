package com.ijse.aad1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private long studentId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;

}
