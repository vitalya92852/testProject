package org.example.project.business.service

import org.example.project.business.dto.StudentDto
import org.example.project.dal.model.EduCard
import org.example.project.dal.model.Student
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

interface StudentService {
    fun create(student: Student): Student
    fun delete(id:Long)
    fun update(id:Long): Student
    fun findAll(pageable:Pageable):Page<Student>
    fun startEducation(studentId:Long,universityId:Long): EduCard
    fun endEducation(studentId:Long): EduCard
    fun changeUniversity(studentId:Long,universityId:Long): EduCard
}