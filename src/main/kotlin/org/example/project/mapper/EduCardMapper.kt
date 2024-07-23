package org.example.project.mapper

import org.example.project.dto.EduCardDto
import org.example.project.model.EduCard

fun EduCard.toDto():EduCardDto{
    return EduCardDto(
        universityDto = this.university?.toDto(),
        studentDto = this.student?.toDto(),
        startEducation = this.startEducation,
        endEducation = this.endEducation
    )
}