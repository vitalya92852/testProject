package org.example.project.business.filter.filterService

import org.example.project.business.filter.StudentSpecification
import org.example.project.business.filter.dto.FilterDto
import org.example.project.dal.model.Student
import org.example.project.dal.repository.StudentRepository
import org.springframework.data.jpa.domain.Specification

class FilterService(
    private val studentRepository: StudentRepository,
) {
    fun filteredStudents(filterDto: FilterDto):List<Student> {
        val specification: Specification<Student> = StudentSpecification.getSpecification(filterDto)
        return studentRepository.findAll(specification)
    }
}