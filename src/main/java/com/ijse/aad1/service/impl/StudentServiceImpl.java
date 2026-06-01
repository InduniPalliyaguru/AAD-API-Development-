package com.ijse.aad1.service.impl;

import com.ijse.aad1.dto.StudentDTO;
import com.ijse.aad1.entity.Student;
import com.ijse.aad1.repository.StudentRepository;
import com.ijse.aad1.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository repository) {
        this.studentRepository = repository;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        log.info("Execute method save student" + studentDTO.toString());

        try {

            if (studentDTO.getFirstName() == null) throw new RuntimeException("First name is required");
            if (studentDTO.getLastName() == null) throw new RuntimeException("Last name is required");
            if (studentDTO.getDob() == null) throw new RuntimeException("Date of birth is required");
            if (studentDTO.getEmail() == null) throw new RuntimeException("Email is required");

            log.info("Saving student to the database...");
            Student student = new Student();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setDob(studentDTO.getDob());
            student.setEmail(studentDTO.getEmail());

            studentRepository.save(student);
        } catch (Exception e) {
            log.error("Error occurred while saving student: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<StudentDTO> getStudents() {
        log.info("Execute method get students");

        try {

            List<StudentDTO> responseList = new ArrayList<>();
            List<Student> studentList = studentRepository.findAll();

            for (Student student : studentList) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudentId(student.getStudentId());
                studentDTO.setFirstName(student.getFirstName());
                studentDTO.setLastName(student.getLastName());
                studentDTO.setDob(student.getDob());
                studentDTO.setEmail(student.getEmail());

                responseList.add(studentDTO);
            }
            return responseList;

        } catch (Exception e) {
            log.error("Error occurred while retrieving students: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public StudentDTO getStudentDetail(long studentId) {
        log.info("Execute method get student detail for studentId: " + studentId);

        try {

            Optional<Student> studentOptional = studentRepository.findById(studentId);
            if (!studentOptional.isPresent()) {
                throw new RuntimeException("Student not found with id: " + studentId);
            }

            Student student = studentOptional.get();
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            studentDTO.setDob(student.getDob());
            studentDTO.setEmail(student.getEmail());

            return studentDTO;

        } catch (Exception e) {
            log.error("Error occurred while retrieving student detail: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        log.info("Execute method update student with studentId: " + studentDTO.getStudentId());

        try {

            if (studentDTO.getFirstName() == null) throw new RuntimeException("First name is required");
            if (studentDTO.getLastName() == null) throw new RuntimeException("Last name is required");
            if (studentDTO.getDob() == null) throw new RuntimeException("Date of birth is required");
            if (studentDTO.getEmail() == null) throw new RuntimeException("Email is required");

            Optional<Student> studentOptional = studentRepository.findById(studentDTO.getStudentId());
            if (!studentOptional.isPresent()) {
                throw new RuntimeException("Student not found with id: " + studentDTO.getStudentId());
            }

            Student student = studentOptional.get();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setDob(studentDTO.getDob());
            student.setEmail(studentDTO.getEmail());

            studentRepository.save(student);

        } catch (Exception e) {
            log.error("Error occurred while updating student: " + e.getMessage());
            throw e;
        }
    }
}
