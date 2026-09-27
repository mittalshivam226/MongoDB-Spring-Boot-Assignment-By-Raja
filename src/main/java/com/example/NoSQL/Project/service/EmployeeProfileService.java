package com.example.NoSQL.Project.service;

import com.example.NoSQL.Project.dto.EmployeeCreateDTO;

import java.util.List;

public interface EmployeeProfileService {
    EmployeeCreateDTO createEmployeeProfile(EmployeeCreateDTO employeeCreateDTO);

    List<EmployeeCreateDTO> fetchEmployees();

    EmployeeCreateDTO getEmployee(String userFirstName);

    void deleteByEmployee(String userFirstName);
}
