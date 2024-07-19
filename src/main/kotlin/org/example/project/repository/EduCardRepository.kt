package org.example.project.repository

import org.example.project.model.EduCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EduCardRepository:JpaRepository<EduCard,Long> {
}