package com.example.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.time.Instant
import java.util.*

@MappedEntity(value = "work_record")
data class WorkRecord(
    @Id
    @GeneratedValue
    val id: UUID?,
    val startTime: Instant,
    val endTime: Instant,
    val shiftId: UUID?,
    val employeeId: UUID?
)

