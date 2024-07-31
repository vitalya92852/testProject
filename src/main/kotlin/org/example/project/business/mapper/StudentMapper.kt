package org.example.project.business.mapper

import org.example.project.business.dto.PageDto
import org.example.project.business.dto.StudentDto
import org.example.project.dal.model.Student
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.request.UpdateStudentRequestDto
import org.springframework.data.domain.Page

fun CreateStudentRequestDto.toEntity(): Student {
    return Student(
        name = this.name,
        lastname = this.lastname,
        birthDay = this.birthDay
    )
}

fun Student.toDto(): StudentDto {

    return StudentDto(
        name = this.name,
        lastname = this.lastname,
        birthDay = this.birthDay,
        id = this.id,
//        city = this.city
    )
}

