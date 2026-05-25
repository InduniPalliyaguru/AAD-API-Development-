package com.ijse.aad1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/api") // http://localhost:8080/v1/api/ping - GET request
@Slf4j // Lombok annotation to generate a logger for the class
public class Test {

    @GetMapping(value = "/ping") // http://localhost:8080/v1/api/ping - GET request
    public String ping() {
        log.info("----Request is here----"); // Log the incoming request
        log.info("----Response processing----");
        return "Application is running...!";
    }

}
