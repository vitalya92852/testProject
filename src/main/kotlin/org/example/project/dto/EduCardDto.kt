package org.example.project.dto

import org.example.project.model.Student
import org.example.project.model.University
import java.time.LocalDate

data class EduCardDto (
    val universityDto:UniversityDto?=null,
    val studentDto:StudentDto?=null,
    val startEducation:LocalDate?=null,
    val endEducation:LocalDate?=null
)

