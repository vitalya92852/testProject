package org.example.project.business.filter.filterFacade

import org.example.project.business.dto.StudentDto
import org.example.project.business.filter.filterService.FilterService
import org.example.project.business.filter.dto.FilterDto
import org.example.project.business.mapper.toDto

class FilterFacade(
    private val filterService: FilterService
) {
    fun getFilteredStudents(filterDto: FilterDto):List<StudentDto> {

        return filterService.filteredStudents(filterDto).map { it.toDto() }
    }

}