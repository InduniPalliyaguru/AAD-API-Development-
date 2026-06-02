package com.ijse.aad1.service.impl;

import com.ijse.aad1.dto.OrderDTO;
import com.ijse.aad1.dto.SaveOrderDTO;
import com.ijse.aad1.entity.Customer;
import com.ijse.aad1.entity.Order;
import com.ijse.aad1.repository.CustomerRepository;
import com.ijse.aad1.repository.OrderRepository;
import com.ijse.aad1.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveOrder(SaveOrderDTO saveOrderDTO) {
        log.info("Execute method save order" + saveOrderDTO.toString());

        log.info("Saving order to the database...");

        try {

            Optional<Customer> customerOptional = customerRepository.findById(saveOrderDTO.getCustomerId());
            Customer customer = customerOptional.get();

            Order order = new Order();

            order.setDescription(saveOrderDTO.getDescription());
            order.setTotalAmount(saveOrderDTO.getTotal());
            order.setCustomer(customer);

            orderRepository.save(order);


        } catch (Exception e) {
            log.error("Error occurred while saving order: " + e.getMessage());
            throw e;
        }

    }
}
