package com.ijse.aad1.service.impl;

import com.ijse.aad1.dto.SchoolDTO;
import com.ijse.aad1.entity.School;
import com.ijse.aad1.repository.SchoolRepository;
import com.ijse.aad1.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public void saveSchool(SchoolDTO schoolDTO) {
        log.info("Execute method save school" + schoolDTO.toString());

        try {

            if (schoolDTO.getSchoolName() == null) throw new RuntimeException("School name is required");
            if (schoolDTO.getLocation() == null) throw new RuntimeException("Location is required");

            log.info("Saving school to the database...");

            School school = new School();
            school.setSchoolName(schoolDTO.getSchoolName());
            school.setLocation(schoolDTO.getLocation());

            schoolRepository.save(school);

        } catch (Exception e) {
            log.error("Error occurred while saving school: " + e.getMessage());
            throw e;
        }

    }

    @Override
    public List<SchoolDTO> getSchools() {
        log.info("Execute method get schools");

        try {

            List<SchoolDTO> responseList = new ArrayList<>();
            List<School> schoolList = schoolRepository.findAll();

            for (School school : schoolList) {
                SchoolDTO dto = new SchoolDTO();
                dto.setSchoolId(school.getSchoolId());
                dto.setSchoolName(school.getSchoolName());
                dto.setLocation(school.getLocation());

                responseList.add(dto);
            }

            return responseList;

        } catch (Exception e) {
            log.error("Error occurred while retrieving schools: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public SchoolDTO getSchoolDetail(long schoolId) {
        log.info("Execute method get school detail with school id: " + schoolId);

        try {

            Optional<School> optionalSchool = schoolRepository.findById(schoolId);
            if (!optionalSchool.isPresent()) {
                throw new RuntimeException("School not found with id: " + schoolId);
            }

            School school = optionalSchool.get();
            SchoolDTO dto = new SchoolDTO();
            dto.setSchoolId(school.getSchoolId());
            dto.setSchoolName(school.getSchoolName());
            dto.setLocation(school.getLocation());

            return dto;

        } catch (Exception e) {
            log.error("Error occurred while retrieving school detail: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateSchool(SchoolDTO schoolDTO) {
        log.info("Execute method update school with school id: " + schoolDTO.getSchoolId());

        try {

            if (schoolDTO.getSchoolName() == null) throw new RuntimeException("School name is required");
            if (schoolDTO.getLocation() == null) throw new RuntimeException("Location is required");

            Optional<School> optionalSchool = schoolRepository.findById(schoolDTO.getSchoolId());
            if (!optionalSchool.isPresent()) {
                throw new RuntimeException("School not found with id: " + schoolDTO.getSchoolId());
            }

            School school = optionalSchool.get();
            school.setSchoolName(schoolDTO.getSchoolName());
            school.setLocation(schoolDTO.getLocation());

            schoolRepository.save(school);

        } catch (Exception e) {
            log.error("Error occurred while updating school: " + e.getMessage());
            throw e;
        }
    }
}
