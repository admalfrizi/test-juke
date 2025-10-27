package com.projects.test_juke.controller;

import com.projects.test_juke.model.entity.Employee;
import com.projects.test_juke.model.request.EmployeeFormRequest;
import com.projects.test_juke.service.IEmployeeService;
import com.projects.test_juke.utils.response.ResponseHandler;
import com.projects.test_juke.utils.response.ResponseHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "API Employee Management", description = "APIs for managing employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get All Employee Data", description = "Menampilkan semua karyawan")
    @GetMapping
    public ResponseEntity<ResponseHelper<List<Employee>>> getAllEmployee()
    {
        try
        {
            List<Employee> responseData = employeeService.getAllEmployee();

            return ResponseHandler.generateResponse(
                    responseData,
                    "Berikut data semua employee",
                    HttpStatus.OK,
                    true
            );
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(
                    null,
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    false
            );
        }

    }

    @Operation(summary = "Create a New Employee Data", description = "Menambahkan data karyawan baru")
    @PostMapping
    public ResponseEntity<ResponseHelper<Employee>> createEmployee(@Valid @RequestBody EmployeeFormRequest employee)
    {
        try
        {
            Employee responseData = employeeService.createEmployee(employee);

            return ResponseHandler.generateResponse(
                    responseData,
                    "Data Employee telah berhasil dibuat !",
                    HttpStatus.OK,
                    true
            );
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(
                    null,
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    false
            );
        }
    }

    @Operation(summary = "Get one employee data", description = "Menampilkan detail 1 karyawan")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseHelper<Employee>> getOneEmployee(@PathVariable long id)
    {
        try
        {
            Employee responseData = employeeService.getOneEmployee(id);

            return ResponseHandler.generateResponse(
                    responseData,
                    "Berikut Data untuk satu employee",
                    HttpStatus.OK,
                    true
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    null,
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    false
            );
        }
    }

    @Operation(summary = "Update a existing employee data", description = "Mengubah data karyawan")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseHelper<Employee>> updateEmployee(@PathVariable long id, @Valid @RequestBody EmployeeFormRequest employee)
    {
        try
        {
            Employee responseData = employeeService.updateEmployee(id, employee);

            return ResponseHandler.generateResponse(
                    responseData,
                    "Data employee telah berhasil di update",
                    HttpStatus.OK,
                    true
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    null,
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    false
            );
        }
    }

    @Operation(summary = "Delete a Employee Data", description = "Menghapus data karyawan")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseHelper<Null>> deleteEmployee(@PathVariable long id)
    {
        try
        {
            employeeService.deleteEmployee(id);

            return ResponseHandler.generateResponse(
                    null,
                    "Data employee telah berhasil di hapus",
                    HttpStatus.OK,
                    true
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    null,
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    false
            );
        }
    }
}
