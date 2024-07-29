package org.example.project.business.facade

import org.example.project.business.dto.PageDto
import org.example.project.business.dto.StudentDto
import org.example.project.business.dto.UniversityDto
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.request.CreateUniversityRequestDto
import org.example.project.business.request.UpdateStudentRequestDto
import org.example.project.business.request.UpdateUniversityRequestDto

interface UniversityFacade {
    fun save(createUniversityRequestDto: CreateUniversityRequestDto): UniversityDto
    fun update(id:Long,updateUniversityRequestDto: UpdateUniversityRequestDto): UniversityDto
    fun delete(id:Long)
    fun findAll(pageNumber:Int,pageSize:Int): PageDto<UniversityDto>
}