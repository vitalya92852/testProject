package org.example.project.facade

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface StudentFacade {
    fun save(studentDto: CreateStudentRequestDto):StudentDto
    fun update(id:Long,updateStudentRequestDto: UpdateStudentRequestDto)
    fun delete(id:Long)
    fun findAll():PageDto<StudentDto>
}