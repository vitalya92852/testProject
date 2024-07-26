package org.example.project.controller

import org.example.project.dto.EduCardDto
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

@RestController
@RequestMapping("/api/v1/student")
class StudentController(
    private val studentFacade: StudentFacade,
    ) {
    @PostMapping()
    fun createStudent(@RequestBody createStudentRequestDto: CreateStudentRequestDto): ResponseEntity<StudentDto> {
        val studentDto = studentFacade.save(createStudentRequestDto)
        return ResponseEntity(studentDto,HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable("id") id:Long,@RequestBody updateStudentRequestDto: UpdateStudentRequestDto):StudentDto{
        return studentFacade.update(id,updateStudentRequestDto)
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable("id") id:Long):ResponseEntity<Unit>{
        studentFacade.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/findAll")
    fun findAllPages(@RequestParam (defaultValue = "1", required = false) pageNumber:Int,
                     @RequestParam (defaultValue = "6", required = false) pageSize:Int): ResponseEntity<PageDto<StudentDto>>{
        val pageContent:PageDto<StudentDto> = studentFacade.findAll(pageNumber, pageSize)
        return ResponseEntity(pageContent,HttpStatus.OK)
    }

    @PutMapping("/startEducation")
    fun startEducation(@RequestParam("studentId") studentId:Long,
                       @RequestParam("universityId") universityId:Long):ResponseEntity<EduCardDto>{
        val eduCardDto:EduCardDto = studentFacade.createEduCard(studentId,universityId)
        return ResponseEntity(eduCardDto,HttpStatus.CREATED)
    }

    @PutMapping("/endEducation")
    fun endEducation(@RequestParam("studentId") studentId: Long):ResponseEntity<EduCardDto>{
        val eduCardDto:EduCardDto = studentFacade.endEducation(studentId)
        return ResponseEntity(eduCardDto,HttpStatus.OK)
    }
    @PutMapping("/changeUniversity")
    fun endEducation(@RequestParam("studentId",) studentId: Long,
                     @RequestParam("universityId") universityId: Long):ResponseEntity<EduCardDto>{
        val eduCardDto:EduCardDto = studentFacade.changeUniversity(studentId,universityId)
        return ResponseEntity(eduCardDto,HttpStatus.OK)
    }
}