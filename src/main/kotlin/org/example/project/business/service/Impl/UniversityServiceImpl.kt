package org.example.project.business.service.Impl

import org.example.project.business.exception.EntityByIdNotFoundException
import org.example.project.dal.model.University
import org.example.project.dal.repository.UniversityRepository
import org.example.project.business.service.UniversityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class UniversityServiceImpl(
    private val universityRepository: UniversityRepository,
    private val logger:Logger = LoggerFactory.getLogger(UniversityServiceImpl::class.java)): UniversityService {
    override fun create(university: University): University {
        return universityRepository.save(university)
    }

    override fun delete(id:Long) {
        val university: University = universityRepository.findById(id).orElseThrow{
            logger.error("Can not find university with id $id")
            EntityByIdNotFoundException(id)
        }
        university.isDeleted = true
    }

    override fun update(id:Long): University {
        val university: University = universityRepository.findById(id).orElseThrow{
            logger.error("Can not find university with id $id")
            EntityByIdNotFoundException(id)
        }
        return universityRepository.save(university)
    }

    override fun findAll(pageable:Pageable): Page<University> {
        return universityRepository.findAll(pageable)
    }

}