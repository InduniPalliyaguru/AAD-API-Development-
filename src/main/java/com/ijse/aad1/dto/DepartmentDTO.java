package com.ijse.aad1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    // This class is a Data Transfer Object (DTO) for the Department entity. It is used to transfer data between different layers of the application,
    // such as between the service layer and the controller layer.

    private long departmentId;
    private String departmentName;
    private String location;

}
