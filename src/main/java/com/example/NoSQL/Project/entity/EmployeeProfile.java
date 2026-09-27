package com.example.NoSQL.Project.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employee_profile")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfile {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private Date dateOfJoining;

}
