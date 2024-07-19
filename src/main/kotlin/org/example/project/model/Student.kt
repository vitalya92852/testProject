package org.example.project.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id:Long?=null,
    @Column(name = "name", nullable = false, length = 100)
    val name:String,
    @Column(name = "lastname", nullable = false)
    val lastname:String,
    @Column(name = "birthDate", nullable = false)
    val birthDay:LocalDate?=null,

    @ManyToMany
    @JoinTable(
        name = "educard",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "university_id")]
    )
    var universities: List<University> = mutableListOf(),

)
