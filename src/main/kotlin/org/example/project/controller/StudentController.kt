package org.example.project.controller

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.facade.StudentFacade
import org.example.project.facade.impl.StudentFacadeImpl
import org.example.project.model.Student
import org.example.project.repository.StudentRepository
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.example.project.service.Impl.StudentServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/student")
class StudentController(
    private val studentFacadeImpl: StudentFacadeImpl,
    ) {
    @PostMapping("/create")
    fun createStudent(@RequestBody createStudentRequestDto: CreateStudentRequestDto): ResponseEntity<StudentDto> {
        val studentDto = studentFacadeImpl.save(createStudentRequestDto)
        return ResponseEntity(studentDto,HttpStatus.CREATED)
    }

//    @PutMapping("/update/{id}")
//    fun updateStudent(@PathVariable("id") id:Long,@RequestBody updateStudentRequestDto: UpdateStudentRequestDto){
//        val studentFacade: StudentFacade = StudentFacadeImpl(studentServiceImpl,)
//
//
//    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable("id") id:Long):ResponseEntity<Unit>{
        studentFacadeImpl.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/findAll")
    fun findAllPages(): ResponseEntity<PageDto<StudentDto>>{
        val pageContent:PageDto<StudentDto> = studentFacadeImpl.findAll()
        return ResponseEntity(pageContent,HttpStatus.OK)
    }
}