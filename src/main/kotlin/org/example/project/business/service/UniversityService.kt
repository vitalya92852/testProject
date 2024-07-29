package org.example.project.business.service

import org.example.project.dal.model.Student
import org.example.project.dal.model.University
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UniversityService {
    fun create(university: University): University
    fun delete(id:Long)
    fun update(id:Long): University
    fun findAll(pageable: Pageable): Page<University>
}