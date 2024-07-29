package org.example.project.business.facade

import org.example.project.business.dto.EduCardDto
import org.example.project.business.dto.PageDto
import org.example.project.business.dto.StudentDto
import org.example.project.dal.model.EduCard
import org.example.project.dal.model.Student
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.request.UpdateStudentRequestDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface StudentFacade {
    fun save(createStudentRequestDto: CreateStudentRequestDto): StudentDto
    fun update(id:Long,updateStudentRequestDto: UpdateStudentRequestDto): StudentDto
    fun delete(id:Long)
    fun findAll(pageNumber:Int,pageSize:Int): PageDto<StudentDto>
    fun createEduCard(studentId:Long,universityId:Long): EduCardDto
    fun endEducation(studentId:Long): EduCardDto
    fun changeUniversity(studentId: Long,universityId: Long): EduCardDto
}