package com.example.NoSQL.Project.serviceImpl;

import com.example.NoSQL.Project.dto.EmployeeCreateDTO;
import com.example.NoSQL.Project.entity.EmployeeProfile;
import com.example.NoSQL.Project.repository.EmployeeProfileRepository;
import com.example.NoSQL.Project.service.EmployeeProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository employeeProfileRepository;

    @Override
    public EmployeeCreateDTO createEmployeeProfile(EmployeeCreateDTO employeeCreateDTO) {

        EmployeeProfile employeeProfile = EmployeeProfile.builder()
                .employeeId(employeeCreateDTO.getEmployeeId())
                .firstName(employeeCreateDTO.getFirstName())
                .lastName(employeeCreateDTO.getLastName())
                .email(employeeCreateDTO.getEmail())
                .dateOfJoining(employeeCreateDTO.getDateOfJoining())
                .build();
        EmployeeProfile emp = employeeProfileRepository.save(employeeProfile);

        EmployeeCreateDTO employeeDTO =  EmployeeCreateDTO.builder()
                .id(emp.getId())
                .employeeId(emp.getEmployeeId())
                .firstName(emp.getFirstName())
                .lastName(emp.getLastName())
                .email(emp.getEmail())
                .dateOfJoining(emp.getDateOfJoining())
                .build();
        return employeeDTO;
    }


    @Override
    public List<EmployeeCreateDTO> fetchEmployees() {

        List<EmployeeProfile> employeeProfileList = employeeProfileRepository.findAll();
        List<EmployeeCreateDTO> employeeCreateDTOList = new ArrayList<>();

        for(EmployeeProfile employeeProfile : employeeProfileList){
            EmployeeCreateDTO employeeDTO =  EmployeeCreateDTO.builder()
                    .id(employeeProfile.getId())
                    .employeeId(employeeProfile.getEmployeeId())
                    .firstName(employeeProfile.getFirstName())
                    .lastName(employeeProfile.getLastName())
                    .email(employeeProfile.getEmail())
                    .dateOfJoining(employeeProfile.getDateOfJoining())
                    .build();
            employeeCreateDTOList.add(employeeDTO);
        }

        return employeeCreateDTOList;
    }

    @Override
    public EmployeeCreateDTO getEmployee(String userFirstName) {

        EmployeeProfile employeeProfile = employeeProfileRepository.getByFirstName(userFirstName);

        return EmployeeCreateDTO.builder()
                .id(employeeProfile.getId())
                .employeeId(employeeProfile.getEmployeeId())
                .firstName(employeeProfile.getFirstName())
                .lastName(employeeProfile.getLastName())
                .email(employeeProfile.getEmail())
                .dateOfJoining(employeeProfile.getDateOfJoining())
                .build();
    }

    @Override
    public void deleteByEmployee(String userFirstName) {

        EmployeeProfile employeeProfile = employeeProfileRepository.getByFirstName(userFirstName);
        employeeProfileRepository.deleteById(employeeProfile.getId());
    }
}
