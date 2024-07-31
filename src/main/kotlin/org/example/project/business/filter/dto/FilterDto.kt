package org.example.project.business.filter.dto

import java.time.LocalDate

data class FilterDto(
    var name:String?=null,
    var lastname:String?=null,
    var birthDay:LocalDate?=null,
    var typeOfStudent:String?=null,
    var city:String?=null,
    var country:String?=null
)