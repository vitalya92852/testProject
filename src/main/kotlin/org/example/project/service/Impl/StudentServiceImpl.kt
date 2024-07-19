package org.example.project.service.Impl

import org.example.project.dto.StudentDto
import org.example.project.enum.PageType
import org.example.project.model.Student
import org.example.project.repository.StudentRepository
import org.example.project.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class StudentServiceImpl(private val studentRepository: StudentRepository): StudentService {

    override fun create(student: Student):Student {
        return studentRepository.save(student)
    }

    override fun delete(id:Long) {
        studentRepository.deleteById(id)
    }

    override fun update(student: Student):Student {
        return studentRepository.save(student)
    }


    override fun findAll(pageable:Pageable): Page<Student> {
        return studentRepository.findAll(pageable)
    }

}