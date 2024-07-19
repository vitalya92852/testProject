package org.example.project.config

import org.example.project.facade.impl.StudentFacadeImpl
import org.example.project.repository.StudentRepository
import org.example.project.service.Impl.StudentServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {



    @Bean
    fun studentServiceImpl(
        studentRepository: StudentRepository
    ):StudentServiceImpl{
        return StudentServiceImpl(studentRepository)
    }

    @Bean
    fun studentFacadeImpl(
        studentRepository: StudentRepository,
        studentServiceImpl:StudentServiceImpl
    ):StudentFacadeImpl{
        return StudentFacadeImpl(
            studentServiceImpl,
            studentRepository
        )
    }
}