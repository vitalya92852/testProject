package org.example.project.mapper

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.model.Student
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.springframework.data.domain.Page

fun CreateStudentRequestDto.toEntity():Student{
    return Student(
        name = this.name,
        lastname = this.lastname,
        birthDay = this.birthDay
    )
}

fun UpdateStudentRequestDto.toEntity():Student{
    return Student(
        name = this.name,
        lastname = this.lastname
    )
}

fun Student.toDto():StudentDto{
    return StudentDto(
        name = this.name,
        lastname = this.lastname,
        birthDay = this.birthDay,
        id = this.id
    )
}

fun<T,R> Page<T>.toPageDto(mapper:(T)->R):PageDto<R>{
    return PageDto(
        pageContent = this.content.map(mapper),
        pageTotalSize = this.totalPages
    )
}