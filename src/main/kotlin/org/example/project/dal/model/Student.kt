package org.example.project.dal.model

import jakarta.persistence.*
import org.example.project.dal.POJO.AddressPOJO
import org.example.project.dal.enum.StudentType
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
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
    @Column(name = "birth_day", nullable = false)
    val birthDay:LocalDate?=null,
    @Column(name = "is_deleted", nullable = false)
    var isDeleted:Boolean = false,
    @Column(name = "type_of_student", nullable = false)
    @Enumerated(EnumType.STRING)
    var type: StudentType = StudentType.BEGINNER,
    @Column(name = "city")
    @Embedded
    @JdbcTypeCode(SqlTypes.JSON)
    var address:AddressPOJO = AddressPOJO(),
    @OneToMany(mappedBy = "student")
    val eduCards: List<EduCard> = emptyList(),


    )
