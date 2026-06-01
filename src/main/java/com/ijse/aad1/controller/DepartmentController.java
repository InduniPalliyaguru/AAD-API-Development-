package com.ijse.aad1.controller;

import com.ijse.aad1.dto.DepartmentDTO;
import com.ijse.aad1.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/departments") // http://localhost:8080/v1/departments - base URL for department-related endpoints
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        // constructor-based dependency injection to inject the DepartmentService into the controller
        this.departmentService = departmentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // http://localhost:8080/v1/departments - POST request to create a new department and specify that the response will be in JSON format
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        // method to handle POST requests to create a new department.
        // It calls the saveDepartment method of the DepartmentService and returns the created DepartmentDTO.
        DepartmentDTO savedDep = departmentService.saveDepartment(departmentDTO);
        return savedDep;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    // http://localhost:8080/v1/departments/all - GET request to retrieve all departments and specify that the response will be in JSON format
    public List<DepartmentDTO> getAllDepartments() {
        // method to handle GET requests to retrieve all departments.
        // It calls the getDepartments method of the DepartmentService and returns a list of DepartmentDTOs.
        List<DepartmentDTO> departmentDTOList = departmentService.getDepartments();
        return departmentDTOList;
    }

    @GetMapping (value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    // http://localhost:8080/v1/departments/{departmentId} - GET request to retrieve a specific department by its ID and specify that the response will be in JSON format
    public DepartmentDTO getDepartmentDetails(@PathVariable long departmentId) {
        // method to handle GET requests to retrieve a specific department by its ID.
        // It calls the getDepartmentDetail method of the DepartmentService and returns the DepartmentDTO for the specified department ID.
        DepartmentDTO departmentDTO = departmentService.getDepartmentDetail(departmentId);
        return departmentDTO;
    }

    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.updateDepartment(departmentDTO);
    }
}
