package com.ijse.aad1.service;

import com.ijse.aad1.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    void saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getStudents();

    StudentDTO getStudentDetail(long studentId);

    void updateStudent(StudentDTO studentDTO);

}
