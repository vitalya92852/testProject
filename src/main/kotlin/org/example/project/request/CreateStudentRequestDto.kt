package org.example.project.request

import java.time.LocalDate

class CreateStudentRequestDto(
    val name:String,
    val lastname:String,
    val birthDay:LocalDate
)