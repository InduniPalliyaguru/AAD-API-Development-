package com.ijse.aad1.service.impl;

import com.ijse.aad1.dto.DepartmentDTO;
import com.ijse.aad1.entity.Department;
import com.ijse.aad1.repository.DepartmentRepository;
import com.ijse.aad1.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    // This class is an implementation of the DepartmentService interface.
    // It contains the business logic for handling department-related operations, such as saving a new department and retrieving all departments.

    private final DepartmentRepository departmentRepository;

    // Constructor-based dependency injection to inject the DepartmentRepository into the service implementation.
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        // This method creates a new Department entity, saves it to the database using the DepartmentRepository,
        // and then converts the saved entity into a DepartmentDTO to return as a response.

        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentLocation(departmentDTO.getLocation());

        // Save the department entity to the database and get the saved entity back (which includes the generated ID).
        Department savedDepartment = departmentRepository.save(department);
        log.info("Department Saved to DB");
        DepartmentDTO responseDTO = new DepartmentDTO();
        responseDTO.setDepartmentId(savedDepartment.getDepartmentId());
        responseDTO.setDepartmentName(savedDepartment.getDepartmentName());
        responseDTO.setLocation(savedDepartment.getDepartmentLocation());

        // Return the DepartmentDTO containing the details of the saved department.
        return responseDTO;
    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        // This method retrieves all Department entities from the database, converts them into DepartmentDTOs,
        // and returns a list of DepartmentDTOs as a response.
        log.info("Execute method get departments");

        try {

            List<DepartmentDTO> responseList = new ArrayList<>();

            // Retrieve all department entities from the database using the DepartmentRepository.
            List<Department> departmentList = departmentRepository.findAll();

            for (Department department : departmentList) {
                DepartmentDTO departmentDTO = new DepartmentDTO();
                departmentDTO.setDepartmentId(department.getDepartmentId());
                departmentDTO.setDepartmentName(department.getDepartmentName());
                departmentDTO.setLocation(department.getDepartmentLocation());
                responseList.add(departmentDTO);
            }
            // Return the list of DepartmentDTOs containing the details of all departments.
            return responseList;
        } catch (Exception e) {
            log.info("Error occurred while fetching departments: " + e.getMessage());
            // In case of any exceptions during the retrieval of departments, log the error message
            // and rethrow the exception to be handled by the global exception handler or the caller.
            throw e;
        }
    }
}
