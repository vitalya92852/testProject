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
    @Column(name = "start_education", nullable = false)
    val startEducation:LocalDate,
    @Column(name = "end_education", nullable = false)
    val endEducation:LocalDate,
    @Column(name = "is_deleted", nullable = false)
    var isDeleted:Boolean = false


)