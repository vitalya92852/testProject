package org.example.project.facade.impl

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.dto.UniversityDto
import org.example.project.facade.UniversityFacade
import org.example.project.mapper.toDto
import org.example.project.mapper.toEntity
import org.example.project.mapper.toPageDto
import org.example.project.model.Student
import org.example.project.model.University
import org.example.project.repository.UniversityRepository
import org.example.project.request.CreateUniversityRequestDto
import org.example.project.request.UpdateUniversityRequestDto
import org.example.project.service.Impl.UniversityServiceImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import kotlin.math.log

class UniversityFacadeImpl(
    private val universityServiceImpl: UniversityServiceImpl,
    private val logger:Logger = LoggerFactory.getLogger(UniversityFacadeImpl::class.java)
    ):UniversityFacade {
    override fun save(createUniversityRequestDto: CreateUniversityRequestDto): UniversityDto {
        val university:University = createUniversityRequestDto.toEntity()
        logger.info("University created with id ${university.id}")
        return universityServiceImpl.create(university).toDto()
    }

    override fun update(id: Long, updateUniversityRequestDto: UpdateUniversityRequestDto): UniversityDto {
        logger.info("University updated with id $id")
        return universityServiceImpl.update(id).toDto()
    }

    override fun delete(id: Long) {
        logger.info("University deleted with id $id")
        universityServiceImpl.delete(id)
    }

    override fun findAll(pageNumber: Int, pageSize: Int): PageDto<UniversityDto> {
        val pageData: PageRequest = PageRequest.of(pageNumber, pageSize)
        logger.info("All universities found page number:${pageNumber} and page size $pageSize")
        return universityServiceImpl.findAll(pageData).toPageDto { it.toDto() }
    }
}