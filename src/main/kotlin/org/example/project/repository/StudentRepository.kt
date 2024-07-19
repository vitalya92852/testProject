package org.example.project.repository

import org.example.project.model.Student
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository:JpaRepository<Student,Long> {
//    fun findAllPages(pageable: Pageable): Page<Student>
}