package org.example.project.repository

import org.example.project.model.EduCard
import org.example.project.model.EduHistory
import org.springframework.data.jpa.repository.JpaRepository

interface EduHistoryRepository:JpaRepository<EduHistory,Long> {
}