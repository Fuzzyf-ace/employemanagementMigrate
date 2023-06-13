package com.example.repository

import com.example.model.Employer
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*

@JdbcRepository(dialect = Dialect.POSTGRES)
interface EmployerRepository : CrudRepository<Employer, UUID> {
     fun findByEmailAndPassword(email: String, password : String) : Employer ?
     fun findByEmail(email: String) : Employer ?
}