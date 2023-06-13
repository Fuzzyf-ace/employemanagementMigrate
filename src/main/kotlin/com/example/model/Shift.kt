package com.example.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.time.Instant
import java.util.*

@MappedEntity(value = "shift")
data class Shift(
    @Id
    @GeneratedValue
    val id: UUID?,
    val description: String,
    val startTime: Instant,
    val endTime: Instant,
    val employerId: UUID?,
    val employeeId: UUID?
)