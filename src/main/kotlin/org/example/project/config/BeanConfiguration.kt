package org.example.project.config

import org.example.project.facade.impl.StudentFacadeImpl
import org.example.project.facade.impl.UniversityFacadeImpl
import org.example.project.repository.EduCardRepository
import org.example.project.repository.StudentRepository
import org.example.project.repository.UniversityRepository
import org.example.project.service.Impl.StudentServiceImpl
import org.example.project.service.Impl.UniversityServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {



    @Bean
    fun studentServiceImpl(
        studentRepository: StudentRepository,
        universityRepository: UniversityRepository,
        eduCardRepository: EduCardRepository
    ):StudentServiceImpl{
        return StudentServiceImpl(
            studentRepository= studentRepository,
            universityRepository =  universityRepository,
            eduCardRepository = eduCardRepository
           )
    }

    @Bean
    fun studentFacadeImpl(
        studentServiceImpl:StudentServiceImpl
    ):StudentFacadeImpl{
        return StudentFacadeImpl(
            studentServiceImpl,
        )
    }

    @Bean
    fun universityServiceImpl(
        universityRepository: UniversityRepository
    ):UniversityServiceImpl{
        return UniversityServiceImpl(universityRepository)
    }

    @Bean
    fun universityFacadeImpl(
        universityServiceImpl: UniversityServiceImpl
    ):UniversityFacadeImpl{
        return UniversityFacadeImpl(universityServiceImpl)
    }
}