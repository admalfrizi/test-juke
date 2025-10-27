package com.projects.test_juke.repository;

import com.projects.test_juke.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
