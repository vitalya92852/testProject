package org.example.project.facade.impl

import jakarta.transaction.Transactional
import org.example.project.dto.EduCardDto
import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.facade.StudentFacade
import org.example.project.mapper.toDto
import org.example.project.mapper.toEntity
import org.example.project.mapper.toPageDto
import org.example.project.model.Student
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.example.project.service.Impl.StudentServiceImpl
import org.example.project.service.StudentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest

open class StudentFacadeImpl (
    private val studentService: StudentService,
    private val logger: Logger = LoggerFactory.getLogger(StudentFacadeImpl::class.java)
    ) :StudentFacade {

    @Transactional
    override fun save(createStudentRequestDto: CreateStudentRequestDto): StudentDto {
        val student: Student = createStudentRequestDto.toEntity()
        logger.info("Student created with id ${student.id}")
        return studentService.create(student).toDto()
    }

    @Transactional
    override fun update(id:Long,updateStudentRequestDto: UpdateStudentRequestDto):StudentDto{
        logger.info("Student updated with id $id")
        return studentService.update(id).toDto()
    }

    @Transactional
    override fun delete(id:Long){
        logger.info("Student deleted with id $id")
        studentService.delete(id)
    }


    override fun findAll(pageNumber:Int,pageSize:Int): PageDto<StudentDto> {
        val pageData:PageRequest = PageRequest.of(pageNumber, pageSize)
        logger.info("All students found page number:${pageNumber} and page size $pageSize")
        return studentService.findAll(pageData).toPageDto { it.toDto() }
    }
    @Transactional
    override fun createEduCard(studentId: Long,universityId:Long): EduCardDto {
        val eduCard = studentService.startEducation(studentId,universityId)
        val eduCardDto = eduCard.toDto()
        logger.info("Created education card with id ${eduCard.id}")
        return eduCardDto
    }

    override fun endEducation(studentId: Long): EduCardDto {
        val eduCardDto = studentService.endEducation(studentId).toDto()
        logger.info("Student with id ${eduCardDto.studentDto?.id} education changed  ${eduCardDto.startEducation}")
        return eduCardDto
    }

    override fun changeUniversity(studentId: Long, universityId: Long):EduCardDto {
        val eduCardDto = studentService.changeUniversity(studentId,universityId).toDto()
        logger.info("Student with id ${eduCardDto.studentDto?.id} university changed  ${eduCardDto.startEducation}")
        return eduCardDto
    }


}