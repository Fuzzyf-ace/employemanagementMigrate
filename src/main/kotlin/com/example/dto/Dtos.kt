package com.example.dto

import com.example.model.Employee
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
data class loginDTO(
    val email : String,
    val password: String,
)

@Introspected
data class EmployeeAddRequest(
    @JsonProperty("employee_data")
    val employee: Employee,
    @JsonProperty("employer_email")
    val employerEmail: String
)
