package com.example.NoSQL.Project.repository;

import com.example.NoSQL.Project.dto.EmployeeCreateDTO;
import com.example.NoSQL.Project.entity.EmployeeProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProfileRepository extends MongoRepository<EmployeeProfile, String> {

    //EmployeeProfile findByFirstName(String userFirstName);

    @Query("{'firstName': ?0}")
    EmployeeProfile getByFirstName(@Param("userFirstName") String userFirstName);

}
