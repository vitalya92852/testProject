package org.example.project.repository

import org.example.project.model.University
import org.springframework.data.jpa.repository.JpaRepository

interface UniversityRepository:JpaRepository<University,Long> {
}