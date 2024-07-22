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
    var name:String,
    @Column(name = "lastname", nullable = false)
    var lastname:String,
    @Column(name = "birth_date", nullable = false)
    val birthDay:LocalDate?=null,
    @Column(name = "is_deleted", nullable = false)
    var isDeleted:Boolean = false,

    @ManyToMany
    @JoinTable(
        name = "educard",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "university_id")]
    )
    var universities: List<University> = mutableListOf(),

)
