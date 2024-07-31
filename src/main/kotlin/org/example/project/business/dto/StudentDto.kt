package org.example.project.business.dto

import org.example.project.dal.POJO.AddressPOJO
import java.time.LocalDate

data class StudentDto(
    val id:Long?,
    val name:String?,
    val lastname:String?,
    val birthDay:LocalDate?,
    val address:AddressPOJO?
)