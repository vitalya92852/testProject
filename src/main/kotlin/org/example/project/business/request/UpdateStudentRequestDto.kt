package org.example.project.business.request

import java.time.LocalDate

data class UpdateStudentRequestDto(
    val name:String?=null,
    val lastname:String?=null,
    val birthDay:LocalDate?
)