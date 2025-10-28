package com.projects.test_juke.repository;

import com.projects.test_juke.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    This repository is requiring from their own JpaRepository in purpose to connect with application.properties that
    initialize for JPA Driver for PostgreSQL, so the code function is generated built from JpaRepository
    and Use in this IEmployeeRepository
*/
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
