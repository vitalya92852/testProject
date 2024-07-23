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
    var startEducation:LocalDate? = null,
    @Column(name = "end_education", nullable = false)
    var endEducation:LocalDate? = null,
    @Column(name = "is_deleted", nullable = false)
    var isDeleted:Boolean = false,
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    var student: Student?=null,
    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    var university: University?=null,


)