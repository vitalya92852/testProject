package org.example.project.mapper

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.dto.UniversityDto
import org.example.project.model.Student
import org.example.project.model.University
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.CreateUniversityRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.springframework.data.domain.Page

fun CreateUniversityRequestDto.toEntity():University{
    return University(
        name = this.name,
        address = this.address,
        city = this.city,
        country = this.country,
    )
}

fun University.toDto():UniversityDto{
    return UniversityDto(
        name = this.name,
        address = this.address,
        city = this.city,
        country = this.country,
    )
}

