package org.example.project.business.dto

import org.example.project.dal.model.Student
import org.example.project.dal.model.University
import java.time.LocalDate

data class EduCardDto (
    val universityDto: UniversityDto?=null,
    val studentDto: StudentDto?=null,
    val startEducation:LocalDate?=null,
    val endEducation:LocalDate?=null
)

