package com.projects.test_juke.service;

import com.projects.test_juke.model.entity.Employee;
import com.projects.test_juke.model.request.EmployeeFormRequest;

import java.util.List;

public interface IEmployeeService
{
    public Employee getOneEmployee(Long id);
    public List<Employee> getAllEmployee();
    public Employee createEmployee(EmployeeFormRequest employee);
    public void updateEmployee();
    public void deleteEmployee();
}
