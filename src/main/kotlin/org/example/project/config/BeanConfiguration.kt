package org.example.project.config

import org.example.project.repository.StudentRepository
import org.example.project.service.Impl.StudentServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {



    @Bean
    fun studentService(
        studentRepository: StudentRepository
    ):StudentServiceImpl{
        return StudentServiceImpl(studentRepository)
    }
}