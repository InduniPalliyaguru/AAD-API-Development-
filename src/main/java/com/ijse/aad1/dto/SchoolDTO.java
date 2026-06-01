package com.ijse.aad1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {

    private long schoolId;
    private String schoolName;
    private String location;

}
