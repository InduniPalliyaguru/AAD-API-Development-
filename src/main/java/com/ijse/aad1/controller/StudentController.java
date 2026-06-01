package com.ijse.aad1.controller;

import com.ijse.aad1.dto.StudentDTO;
import com.ijse.aad1.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return "Student Saved Successfully";
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudentDetails(@PathVariable long studentId) {
        return studentService.getStudentDetail(studentId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return "Student Updated Successfully";
    }

}
