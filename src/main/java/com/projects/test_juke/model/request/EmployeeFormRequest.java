package com.projects.test_juke.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public record EmployeeFormRequest
(
    @NotBlank(message = "Data nama tidak boleh kosong")
     String name,

    @NotBlank(message = "Data email tidak boleh kosong")
    String email,

    String position,

    @Positive(message = "Data Gaji harus berada di angka lebih dari 0")
    double salary
){

}
