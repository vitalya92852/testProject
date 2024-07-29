package org.example.project.business.dto

data class PageDto<T>(
    val pageContent :List<T>,
    val pageTotalSize:Int
)