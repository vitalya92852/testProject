package org.example.project.business.mapper

import org.example.project.business.dto.EduCardDto
import org.example.project.dal.model.EduCard

fun EduCard.toDto(): EduCardDto {
    return EduCardDto(
        universityDto = this.university?.toDto(),
        studentDto = this.student?.toDto(),
        startEducation = this.startEducation,
        endEducation = this.endEducation
    )
}