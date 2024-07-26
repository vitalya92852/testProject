package org.example.project.service.Impl

import org.example.project.enum.EduPeriod
import org.example.project.enum.StudentType
import org.example.project.exception.EntityByIdNotFoundException
import org.example.project.model.EduCard
import org.example.project.model.Student
import org.example.project.model.University
import org.example.project.repository.EduCardRepository
import org.example.project.repository.StudentRepository
import org.example.project.repository.UniversityRepository
import org.example.project.service.StudentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate
import java.time.Period

open class StudentServiceImpl(
    private val studentRepository: StudentRepository,
    private val logger: Logger = LoggerFactory.getLogger(StudentServiceImpl::class.java),
    private val universityRepository: UniversityRepository,
    private val eduCardRepository: EduCardRepository): StudentService {

    override fun create(student: Student):Student {
        return studentRepository.save(student)
    }

    override fun delete(id:Long) {
        studentRepository.findById(id).orElseThrow{
            logger.error("Can not find student with id ${id}")
            EntityByIdNotFoundException(id)
        }.apply {
            isDeleted = true
        }

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

    override fun startEducation(studentId: Long,universityId:Long): EduCard {
        val student:Student = studentRepository.findById(studentId).orElseThrow{
            logger.error("Can not find student with id $studentId")
            EntityByIdNotFoundException(studentId)
        }.apply {
            type = StudentType.STUDENT
            studentRepository.save(this)
        }

        val university:University = universityRepository.findById(universityId).orElseThrow{
            logger.error("Can not find university with id $universityId")
            EntityByIdNotFoundException(universityId)
        }

        val eduCard = EduCard().apply {
            startEducation = LocalDate.now()
            startEducation?.let { startEducation ->
                endEducation = startEducation.plus(Period.ofYears(EduPeriod.THREE_YEARS_EDUCATION.years.toInt()))
            }
            this.student = student
            this.university = university
        }

        return eduCardRepository.save(eduCard)
    }

    override fun endEducation(studentId:Long):EduCard {
        val eduCard = eduCardRepository.findEduCardByStudentId(studentId).apply {
            endEducation = LocalDate.now()
        }
        studentRepository.findById(studentId).orElseThrow{
            logger.error("Can not find student with id $studentId")
            EntityByIdNotFoundException(studentId)
        }.apply {
            type = StudentType.END_EDUCATION
            studentRepository.save(this)
        }

        return eduCardRepository.save(eduCard)
    }

    override fun changeUniversity(studentId: Long,universityId: Long): EduCard {
        val university:University = universityRepository.findById(universityId).orElseThrow{
            logger.error("Can not find university with id $studentId")
            EntityByIdNotFoundException(universityId)
        }
        val eduCard:EduCard = eduCardRepository.findEduCardByStudentId(studentId).apply {
            this.university = university
        }
        return eduCardRepository.save(eduCard)
    }


}