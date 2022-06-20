package com.optum.reboot.azure.cosmosapp.cosmossampleapp.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.optum.reboot.azure.cosmosapp.cosmossampleapp.entities.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CosmosRepository<Employee, String> {

    Iterable<Employee> findByFirstName(String firstName);

    Employee findByIdAndLastName(String id, String lastName);
}

