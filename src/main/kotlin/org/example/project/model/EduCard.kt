package org.example.project.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "educard")
data class EduCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id:Long?= null,
    @Column(name = "startEducation", nullable = false)
    val startEducation:LocalDate,
    @Column(name = "endEducation", nullable = false)
    val endEducation:LocalDate,


)