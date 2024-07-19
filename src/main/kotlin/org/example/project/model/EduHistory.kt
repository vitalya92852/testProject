package org.example.project.model

import jakarta.persistence.*

@Entity
@Table(name = "eduhistory")
data class EduHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id:Long?=null,

)