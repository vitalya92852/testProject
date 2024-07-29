package org.example.project.business.mapper

import org.example.project.business.dto.PageDto
import org.springframework.data.domain.Page

fun<T,R> Page<T>.toPageDto(mapper:(T)->R): PageDto<R> {
    return PageDto(
        pageContent = this.content.map(mapper),
        pageTotalSize = this.totalPages
    )
}