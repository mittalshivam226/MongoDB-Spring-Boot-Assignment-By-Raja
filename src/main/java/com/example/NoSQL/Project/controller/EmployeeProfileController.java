package com.example.NoSQL.Project.controller;


import com.example.NoSQL.Project.dto.EmployeeCreateDTO;
import com.example.NoSQL.Project.serviceImpl.EmployeeProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeProfile")
@RequiredArgsConstructor
public class EmployeeProfileController {

    @Autowired
    private EmployeeProfileServiceImpl employeeProfileServiceImpl;


    @PostMapping
    ResponseEntity<EmployeeCreateDTO> createEmployeeProfile(@RequestBody EmployeeCreateDTO employeeCreateDTO){
        EmployeeCreateDTO employeeCreateDTO1 = employeeProfileServiceImpl.createEmployeeProfile(employeeCreateDTO);

        return ResponseEntity.ok().body(employeeCreateDTO1);
    }

    @GetMapping("/fetchEmployees")
    ResponseEntity<List<EmployeeCreateDTO>> fetchEmployees(){
        List<EmployeeCreateDTO> employeeCreateDTOList = employeeProfileServiceImpl.fetchEmployees();

        return ResponseEntity.ok().body(employeeCreateDTOList);
    }

    @GetMapping("/getEmployee")
    ResponseEntity<EmployeeCreateDTO> getEmployee(@RequestParam String userFirstName){
        EmployeeCreateDTO employeeCreateDTO = employeeProfileServiceImpl.getEmployee(userFirstName);

        return ResponseEntity.ok().body(employeeCreateDTO);
    }

    @DeleteMapping("/deleteEmployee")
    ResponseEntity<Void> deleteEmployee(@RequestParam String userFirstName){
        employeeProfileServiceImpl.deleteByEmployee(userFirstName);
        return ResponseEntity.ok().build();
    }
}
