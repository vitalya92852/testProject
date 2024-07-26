package org.example.project.config

import org.example.project.facade.StudentFacade
import org.example.project.facade.impl.StudentFacadeImpl
import org.example.project.facade.impl.UniversityFacadeImpl
import org.example.project.repository.EduCardRepository
import org.example.project.repository.StudentRepository
import org.example.project.repository.UniversityRepository
import org.example.project.service.Impl.StudentServiceImpl
import org.example.project.service.Impl.UniversityServiceImpl
import org.example.project.service.StudentService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {



    @Bean
    fun studentService(
        studentRepository: StudentRepository,
        universityRepository: UniversityRepository,
        eduCardRepository: EduCardRepository
    ):StudentService{
        return StudentServiceImpl(
            studentRepository= studentRepository,
            universityRepository =  universityRepository,
            eduCardRepository = eduCardRepository
           )
    }

    @Bean
    fun studentFacade(
        studentService:StudentService
    ): StudentFacade {
        return StudentFacadeImpl(
            studentService,
        )
    }

    @Bean
    fun universityService(
        universityRepository: UniversityRepository
    ):UniversityServiceImpl{
        return UniversityServiceImpl(universityRepository)
    }

    @Bean
    fun universityFacade(
        universityServiceImpl: UniversityServiceImpl
    ):UniversityFacadeImpl{
        return UniversityFacadeImpl(universityServiceImpl)
    }
}