package org.example.project.service

import org.example.project.model.Student
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

interface StudentService {
    fun create(student:Student):Student
    fun delete(id:Long)
    fun update(student: Student)
    fun findAll(pageable:Pageable):Page<Student>
}