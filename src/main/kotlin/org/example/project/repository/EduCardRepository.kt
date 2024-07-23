package org.example.project.repository

import org.example.project.model.EduCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EduCardRepository:JpaRepository<EduCard,Long> {
    @Query("SELECT e FROM EduCard e WHERE e.student.id = :id")
    fun findEduCardByStudentId(id:Long):EduCard
}