package org.example.project.web.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.example.project.business.dto.EduCardDto
import org.example.project.business.dto.PageDto
import org.example.project.business.dto.StudentDto
import org.example.project.business.facade.StudentFacade
import org.example.project.business.filter.dto.FilterDto
import org.example.project.business.filter.filterFacade.FilterFacade
import org.example.project.business.mapper.toDto
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.request.FetchFilterStudentRequestDto
import org.example.project.business.request.UpdateStudentRequestDto
import org.example.project.business.service.StudentService
import org.example.project.dal.repository.StudentRepository
import org.springdoc.core.annotations.ParameterObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import toLocalDate

@RestController
@RequestMapping("/api/v1/student")
@Api(description = "Controller for students")
class StudentController(
    private val studentFacade: StudentFacade,
    private val filterFacade: FilterFacade
    ) {
    @PostMapping()
    @ApiOperation("Create student")
    fun createStudent(@RequestBody createStudentRequestDto: CreateStudentRequestDto): ResponseEntity<StudentDto> {
        val studentDto = studentFacade.save(createStudentRequestDto)
        return ResponseEntity(studentDto,HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @ApiOperation("Update student by id")
    fun updateStudent(@PathVariable("id") id:Long,@RequestBody updateStudentRequestDto: UpdateStudentRequestDto): StudentDto {
        return studentFacade.update(id,updateStudentRequestDto)
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete student by id")
    fun deleteStudent(@PathVariable("id") id:Long):ResponseEntity<Unit>{
        studentFacade.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/findAll")
    @ApiOperation("Find all students")
    fun findAllPages(@RequestParam (defaultValue = "1", required = false) pageNumber:Int,
                     @RequestParam (defaultValue = "6", required = false) pageSize:Int): ResponseEntity<PageDto<StudentDto>>{
        val pageContent: PageDto<StudentDto> = studentFacade.findAll(pageNumber, pageSize)
        return ResponseEntity(pageContent,HttpStatus.OK)
    }

    @PutMapping("/startEducation")
    @ApiOperation("Start student education")
    fun startEducation(@RequestParam("studentId") studentId:Long,
                       @RequestParam("universityId") universityId:Long):ResponseEntity<EduCardDto>{
        val eduCardDto: EduCardDto = studentFacade.createEduCard(studentId,universityId)
        return ResponseEntity(eduCardDto,HttpStatus.CREATED)
    }

    @PutMapping("/endEducation")
    @ApiOperation("End student education")
    fun endEducation(@RequestParam("studentId") studentId: Long):ResponseEntity<EduCardDto>{
        val eduCardDto: EduCardDto = studentFacade.endEducation(studentId)
        return ResponseEntity(eduCardDto,HttpStatus.OK)
    }
    @PutMapping("/changeUniversity")
    @ApiOperation("Change university for student")
    fun endEducation(@RequestParam("studentId") studentId: Long,
                     @RequestParam("universityId") universityId: Long):ResponseEntity<EduCardDto>{
        val eduCardDto: EduCardDto = studentFacade.changeUniversity(studentId,universityId)
        return ResponseEntity(eduCardDto,HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getStudent(@PathVariable("id") id:Long):ResponseEntity<StudentDto>{
        val studentDto = studentFacade.get(id)
        return ResponseEntity(studentDto,HttpStatus.OK)
    }

    @GetMapping("/filter")
    @ApiOperation("Filter students by params")
    fun studentFilter(@ParameterObject filterParams:FetchFilterStudentRequestDto):ResponseEntity<List<StudentDto>>{
        val filterDto = FilterDto().apply {
            this.name = filterParams.name
            this.lastname = filterParams.lastname
            this.birthDay = filterParams.birthDay.toLocalDate()
            this. typeOfStudent = filterParams.typeOfStudent
        }
        val listStudentDto = filterFacade.getFilteredStudents(filterDto)
        return  ResponseEntity(listStudentDto,HttpStatus.OK)
    }
}