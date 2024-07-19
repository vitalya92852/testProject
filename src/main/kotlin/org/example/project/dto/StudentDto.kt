package org.example.project.dto

import java.time.LocalDate

data class StudentDto(
    val id:Long?,
    val name:String,
    val lastname:String,
    val birthDay:LocalDate?,
)