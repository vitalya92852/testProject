package org.example.project.dal.repository

import org.example.project.dal.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StudentRepository:JpaRepository<Student,Long>,JpaSpecificationExecutor<Student> {

}