package org.example.project.web.controller

import org.aspectj.lang.annotation.Before
import org.example.project.business.facade.StudentFacade
import org.example.project.business.facade.impl.StudentFacadeImpl
import org.example.project.business.mapper.toDto
import org.example.project.business.mapper.toEntity
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.service.StudentService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDate
@SpringBootTest
class StudentControllerTest{
    @Mock
    private lateinit var studentFacade:StudentFacade

    @Mock
    private lateinit var studentService: StudentService

    private lateinit var createStudentRequestDto:CreateStudentRequestDto

    @BeforeEach
    fun setup(){
        createStudentRequestDto = CreateStudentRequestDto(
            name = "Vitaliy",
            lastname = "Kol",
            birthDay = LocalDate.of(2020,12,20)
        )
    }
    @Test
    fun createStudentTest_ReturnTrue(){
        `when`(studentFacade.save(createStudentRequestDto)).thenReturn(createStudentRequestDto.toEntity().toDto())
        val student = studentFacade.save(createStudentRequestDto)
        Assertions.assertNotNull(student,"Student must be not null")
    }

//    @Test
//    fun deleteStudentTest_ReturnTrue(){
//        val student =  studentService.create(createStudentRequestDto.toEntity())
//        `when`(stu)
//    }

}