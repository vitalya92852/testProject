package org.example.project.facade.impl

import jakarta.transaction.Transactional
import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.enum.PageType
import org.example.project.facade.StudentFacade
import org.example.project.mapper.toDto
import org.example.project.mapper.toEntity
import org.example.project.mapper.toPageDto
import org.example.project.model.Student
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.example.project.service.Impl.StudentServiceImpl
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

open class StudentFacadeImpl (
    private val studentService: StudentServiceImpl
    ) :StudentFacade {

    @Transactional
    override fun save(studentDto: CreateStudentRequestDto): StudentDto {
        val student: Student = studentDto.toEntity()
        return studentService.create(student).toDto()
    }

    @Transactional
    override fun update(id:Long,updateStudentRequestDto: UpdateStudentRequestDto){

    }

    @Transactional
    override fun delete(id:Long){
        studentService.delete(id)
    }


    override fun findAll(): PageDto<StudentDto> {
        val pageData:PageRequest = PageRequest.of(PageType.PAGE_CONTENT.value, PageType.PAGE_TOTAL_SIZE.value)
        return studentService.findAll(pageData).toPageDto { it.toDto() }
    }

}