package org.example.project.facade

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.dto.UniversityDto
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.CreateUniversityRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.example.project.request.UpdateUniversityRequestDto

interface UniversityFacade {
    fun save(createUniversityRequestDto: CreateUniversityRequestDto): UniversityDto
    fun update(id:Long,updateUniversityRequestDto: UpdateUniversityRequestDto): UniversityDto
    fun delete(id:Long)
    fun findAll(pageNumber:Int,pageSize:Int): PageDto<UniversityDto>
}