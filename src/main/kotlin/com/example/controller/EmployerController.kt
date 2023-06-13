package com.example.controller

import com.example.dto.EmployeeAddRequest
import com.example.dto.loginDTO
import com.example.model.Employee
import com.example.model.Employer
import com.example.service.EmployeeService
import com.example.service.EmployerService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/employer")
class EmployerController(
    private val employerService: EmployerService,
    private val employeeService: EmployeeService
) {
    @Post("/signup")
    fun signup(@Body employer: Employer) {
        println(employer.toString())
        employerService.addEmployer(employer)
    }

    @Get("/list")
    fun list(): List<Employer> {
        return employerService.listEmployer()
    }

    @Post("/login")
    fun login(@Body loginDTO: loginDTO): Employer? {
        println(loginDTO.toString())
        return employerService.login(loginDTO)
    }

    @Post("/addEmployee")
    fun addEmployee(@Body employeeAddRequest: EmployeeAddRequest) : Employee? {
        println(employeeAddRequest)
        return employeeService.addEmployee(employeeAddRequest.employee, employeeAddRequest.employerEmail)
    }
}