package org.example.project.model

import jakarta.persistence.*

@Entity
@Table(name = "university")
data class University(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id:Long?=null,
    @Column(name = "name", nullable = false)
    val name:String,
    @Column(name = "country", nullable = false)
    val country:String,
    @Column(name = "city", nullable = false)
    val city:String,
    @Column(name = "address", nullable = false)
    val address:String,
    @ManyToMany(mappedBy = "universities")
    var students:List<Student>


)