package com.ijse.aad1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private long orderId;
    private Date orderDate;
    private double totalAmount;
    private long customerId;

}
