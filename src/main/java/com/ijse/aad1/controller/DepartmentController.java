package com.ijse.aad1.controller;

import com.ijse.aad1.constant.CommonResponse;
import com.ijse.aad1.dto.DepartmentDTO;
import com.ijse.aad1.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ijse.aad1.constant.ResponseMessage.SUCCESS_MESSAGE;
import static com.ijse.aad1.constant.ResponseStatusCode.OPERATION_SUCCESS;

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
    public CommonResponse saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        // method to handle POST requests to create a new department.
        // It calls the saveDepartment method of the DepartmentService and returns the created DepartmentDTO.
        DepartmentDTO savedDep = departmentService.saveDepartment(departmentDTO);

        // After saving the department, it returns a CommonResponse object with a success status code and a success message.
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)// http://localhost:8080/v1/departments/all - GET request to retrieve all departments and specify that the response will be in JSON format
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

    @GetMapping (value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterDepartments(@RequestParam(value = "departmentName", required = false) String name, // @RequestParam annotation is used to bind the name query parameter from the URL to the method parameter
                                                 @RequestParam(value = "departmentLocation", required = false) String location) {
        List<DepartmentDTO> departmentDTOList = departmentService.filterDepartments(name, location);

        // After filtering the departments based on the provided name and location, it returns a CommonResponse object with a success status code, the list of filtered DepartmentDTOs as the response body, and a success message.
        return new CommonResponse(OPERATION_SUCCESS, departmentDTOList, SUCCESS_MESSAGE);
    }
}
