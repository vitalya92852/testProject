package org.example.project.service.Impl

import org.example.project.exseption.EntityByIdNotFoundException
import org.example.project.facade.impl.StudentFacadeImpl
import org.example.project.model.Student
import org.example.project.repository.StudentRepository
import org.example.project.service.StudentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import kotlin.math.log

class StudentServiceImpl(
    private val studentRepository: StudentRepository,
    private val logger: Logger = LoggerFactory.getLogger(StudentServiceImpl::class.java)): StudentService {

    override fun create(student: Student):Student {
        return studentRepository.save(student)
    }

    override fun delete(id:Long) {
        val student:Student = studentRepository.findById(id).orElseThrow{
            logger.error("Can not find student with id ${id}")
            EntityByIdNotFoundException(id)
        }
        student.isDeleted = true
    }

    override fun update(id:Long):Student {
        val student:Student = studentRepository.findById(id).orElseThrow{
            logger.error("Cannot find student with id ${id}")
            EntityByIdNotFoundException(id)
        }
        return studentRepository.save(student)
    }


    override fun findAll(pageable:Pageable): Page<Student> {
        return studentRepository.findAll(pageable)
    }

}