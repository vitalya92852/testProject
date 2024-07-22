package org.example.project.facade.impl

import jakarta.transaction.Transactional
import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.exseption.EntityByIdNotFoundException
import org.example.project.facade.StudentFacade
import org.example.project.mapper.toDto
import org.example.project.mapper.toEntity
import org.example.project.mapper.toPageDto
import org.example.project.model.Student
import org.example.project.repository.StudentRepository
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.example.project.service.Impl.StudentServiceImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import kotlin.math.log

open class StudentFacadeImpl (
    private val studentServiceImpl: StudentServiceImpl,
    private val logger: Logger = LoggerFactory.getLogger(StudentFacadeImpl::class.java)
    ) :StudentFacade {

    @Transactional
    override fun save(createStudentRequestDto: CreateStudentRequestDto): StudentDto {
        val student: Student = createStudentRequestDto.toEntity()
        logger.info("Student created with id ${student.id}")
        return studentServiceImpl.create(student).toDto()
    }

    @Transactional
    override fun update(id:Long,updateStudentRequestDto: UpdateStudentRequestDto):StudentDto{
        logger.info("Student updated with id $id")
        return studentServiceImpl.update(id).toDto()
    }

    @Transactional
    override fun delete(id:Long){
        logger.info("Student deleted with id $id")
        studentServiceImpl.delete(id)
    }


    override fun findAll(pageNumber:Int,pageSize:Int): PageDto<StudentDto> {
        val pageData:PageRequest = PageRequest.of(pageNumber, pageSize)
        logger.info("All students found page number:${pageNumber} and page size $pageSize")
        return studentServiceImpl.findAll(pageData).toPageDto { it.toDto() }
    }

}