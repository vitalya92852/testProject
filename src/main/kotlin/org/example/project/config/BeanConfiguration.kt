package org.example.project.config

import org.example.project.business.facade.StudentFacade
import org.example.project.business.facade.impl.StudentFacadeImpl
import org.example.project.business.facade.impl.UniversityFacadeImpl
import org.example.project.business.filter.filterFacade.FilterFacade
import org.example.project.business.filter.filterService.FilterService
import org.example.project.dal.repository.EduCardRepository
import org.example.project.dal.repository.StudentRepository
import org.example.project.dal.repository.UniversityRepository
import org.example.project.business.service.Impl.StudentServiceImpl
import org.example.project.business.service.Impl.UniversityServiceImpl
import org.example.project.business.service.StudentService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {



    @Bean
    fun studentService(
        studentRepository: StudentRepository,
        universityRepository: UniversityRepository,
        eduCardRepository: EduCardRepository
    ): StudentService {
        return StudentServiceImpl(
            studentRepository= studentRepository,
            universityRepository =  universityRepository,
            eduCardRepository = eduCardRepository
           )
    }

    @Bean
    fun filterService(
        studentRepository: StudentRepository,
    ): FilterService {
        return FilterService(
            studentRepository,
        )
    }

    @Bean
    fun filterFacade(
        filterService: FilterService
    ): FilterFacade {
        return FilterFacade(
            filterService
        )
    }

    @Bean
    fun studentFacade(
        studentService: StudentService
    ): StudentFacade {
        return StudentFacadeImpl(
            studentService,
        )
    }

    @Bean
    fun universityService(
        universityRepository: UniversityRepository
    ): UniversityServiceImpl {
        return UniversityServiceImpl(universityRepository)
    }

    @Bean
    fun universityFacade(
        universityServiceImpl: UniversityServiceImpl
    ): UniversityFacadeImpl {
        return UniversityFacadeImpl(universityServiceImpl)
    }
}