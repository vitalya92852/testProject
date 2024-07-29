package org.example.project.dal.repository

import org.example.project.dal.model.University
import org.springframework.data.jpa.repository.JpaRepository

interface UniversityRepository:JpaRepository<University,Long> {
}