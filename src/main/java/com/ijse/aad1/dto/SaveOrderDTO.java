package com.ijse.aad1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderDTO {

    private double total;
    private String description;
    private long customerId;

}
