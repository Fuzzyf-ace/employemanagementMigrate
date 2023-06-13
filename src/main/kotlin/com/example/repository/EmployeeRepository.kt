package com.example.repository

import com.example.model.Employee
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*

@JdbcRepository(dialect = Dialect.POSTGRES)
interface EmployeeRepository : CrudRepository<Employee, UUID> {
//    @Query("")
//    fun getEmployeeById(employerId: UUID) : EmployeeData

    fun findByEmail(email: String) : Employee ?
    fun save(employee: Employee, employer: UUID): Employee
}