package org.example.project.business.request

data class FetchFilterStudentRequestDto(
    val name:String?,
    val lastname:String?,
    val birthDay:String?,
    val typeOfStudent:String?,
    val city:String?,
    val country:String?

)