package org.example.project.dal.repository

import org.example.project.dal.model.EduCard
import org.example.project.dal.model.EduHistory
import org.springframework.data.jpa.repository.JpaRepository

interface EduHistoryRepository:JpaRepository<EduHistory,Long> {
}