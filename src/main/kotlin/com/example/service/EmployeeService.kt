package com.example.service

import com.example.model.Employee
import com.example.repository.EmployeeRepository
import com.example.repository.EmployerRepository
import jakarta.inject.Singleton

@Singleton
class EmployeeService (
    private val employeeRepository: EmployeeRepository,
    private val employerRepository: EmployerRepository,
) {
    fun addEmployee(employee: Employee, employerEmail: String): Employee ? {
        val employer = employerRepository.findByEmail(employerEmail)
        if (employer != null) {
            employee.employerId = employer.id
            return employeeRepository.save(employee)
        }
        throw Exception("employer does not exist")
    }
}