package com.ijse.aad1.service;

import com.ijse.aad1.dto.SchoolDTO;

import java.util.List;

public interface SchoolService {

    void saveSchool(SchoolDTO schoolDTO);

    List<SchoolDTO> getSchools();

    SchoolDTO getSchoolDetail(long schoolId);

    void updateSchool(SchoolDTO schoolDTO);
}
