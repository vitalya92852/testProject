package org.example.project.business.filter.dto

import org.example.project.dal.POJO.CityPOJO
import java.time.LocalDate

data class FilterDto(
    var name:String?=null,
    var lastname:String?=null,
    var birthDay:LocalDate?=null,
    var typeOfStudent:String?=null,
//    var city:CityPOJO?=null
)