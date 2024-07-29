package org.example.project.business.mapper

import org.example.project.business.dto.PageDto
import org.example.project.business.dto.StudentDto
import org.example.project.business.dto.UniversityDto
import org.example.project.dal.model.Student
import org.example.project.dal.model.University
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.request.CreateUniversityRequestDto
import org.example.project.business.request.UpdateStudentRequestDto
import org.springframework.data.domain.Page

fun CreateUniversityRequestDto.toEntity(): University {
    return University(
        name = this.name,
        address = this.address,
        city = this.city,
        country = this.country,
    )
}

fun University.toDto(): UniversityDto {
    return UniversityDto(
        name = this.name,
        address = this.address,
        city = this.city,
        country = this.country,
    )
}

