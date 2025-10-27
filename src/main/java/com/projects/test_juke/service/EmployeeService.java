package com.projects.test_juke.service;

import com.projects.test_juke.model.entity.Employee;
import com.projects.test_juke.model.request.EmployeeFormRequest;
import com.projects.test_juke.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService
{

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Employee getOneEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->  new RuntimeException("Data Tidak Ditemukan"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(EmployeeFormRequest employee) {
        Employee insertData = new Employee();
        insertData.setName(employee.name());
        insertData.setEmail(employee.email());
        insertData.setPosition(employee.position());
        insertData.setSalary(employee.salary());

        return employeeRepository.save(insertData);
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee() {

    }
}
