package com.ijse.aad1.controller;

import com.ijse.aad1.dto.SchoolDTO;
import com.ijse.aad1.service.SchoolService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.saveSchool(schoolDTO);
        return "School Saved Successfully";
    }

    @GetMapping (value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getSchools();
    }

    @GetMapping (value = "/{schoolId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolDTO getSchoolDetails(@PathVariable long schoolId) {
        return schoolService.getSchoolDetail(schoolId);
    }

    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.updateSchool(schoolDTO);
        return "School Updated Successfully";
    }
}
