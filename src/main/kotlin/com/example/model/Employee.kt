package com.example.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.math.BigDecimal
import java.util.UUID

@MappedEntity(value = "employees")
data class Employee(
    @field: Id
//    @Id
    @GeneratedValue
    val id : UUID ?,
    val email : String,
    val password: String,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
    val active: Boolean,
    @JsonProperty("pay_rate")
    val payRate: BigDecimal,
    var employerId: UUID ?,
//    val userRole: Int
) {

}





