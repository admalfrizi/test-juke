package com.projects.test_juke.service;

import com.projects.test_juke.model.entity.Employee;
import com.projects.test_juke.model.request.EmployeeFormRequest;

import java.util.List;

public interface IEmployeeService
{
    Employee getOneEmployee(Long id);
    List<Employee> getAllEmployee();
    Employee createEmployee(EmployeeFormRequest employee);
    Employee updateEmployee(Long id, EmployeeFormRequest employee);
    void deleteEmployee(Long id);
}
