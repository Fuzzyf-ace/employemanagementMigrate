package com.example.service

import com.example.dto.loginDTO
import com.example.model.Employer
import com.example.repository.EmployerRepository
import jakarta.inject.Singleton

@Singleton
class EmployerService(
    private val employerRepository: EmployerRepository,
) {
    fun addEmployer(employer: Employer): Employer {
        return employerRepository.save(employer)
    }
    fun findByEmail(email : String) : Employer ? {
        return employerRepository.findByEmail(email)
    }
    fun listEmployer() : List<Employer> {
        return employerRepository.findAll() as List<Employer>
    }

    fun login(loginDTO: loginDTO) : Employer ? {
        return employerRepository.findByEmailAndPassword(loginDTO.email, loginDTO.password)
    }
}