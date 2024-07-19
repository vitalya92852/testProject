package org.example.project.dto

data class PageDto<T>(
    val pageContent :List<T>,
    val pageTotalSize:Int
)