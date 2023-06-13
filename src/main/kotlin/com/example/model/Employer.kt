package com.example.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.util.*

@MappedEntity(value = "employers")
data class Employer(
    @field: Id
//    @Id
    @GeneratedValue
    val id: UUID?,
    val email: String,
    val password: String,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
//    @JsonProperty("user_role")
//    val userRole: Int,
)
