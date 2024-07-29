package org.example.project.web.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.example.project.business.dto.PageDto
import org.example.project.business.dto.StudentDto
import org.example.project.business.dto.UniversityDto
import org.example.project.business.facade.UniversityFacade
import org.example.project.business.facade.impl.UniversityFacadeImpl
import org.example.project.business.request.CreateStudentRequestDto
import org.example.project.business.request.CreateUniversityRequestDto
import org.example.project.business.request.UpdateStudentRequestDto
import org.example.project.business.request.UpdateUniversityRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/university")
@Api(description = "Controller for university")
class UniversityController(
    private val universityFacade: UniversityFacadeImpl
) {
    @PostMapping()
    @ApiOperation("Create university")
    fun createUniversity(@RequestBody createUniversityRequestDto: CreateUniversityRequestDto): ResponseEntity<UniversityDto> {
        val universityDto = universityFacade.save(createUniversityRequestDto)
        return ResponseEntity(universityDto, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @ApiOperation("Update university")
    fun updateUniversity(@PathVariable("id") id:Long, @RequestBody updateUniversityRequestDto: UpdateUniversityRequestDto): UniversityDto {
        return universityFacade.update(id,updateUniversityRequestDto)
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete university by id")
    fun deleteUniversity(@PathVariable("id") id:Long): ResponseEntity<Unit> {
        universityFacade.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/findAll")
    @ApiOperation("Find all universities")
    fun findAllPages(@RequestParam(defaultValue = "1", required = false) pageNumber:Int,
                     @RequestParam(defaultValue = "6", required = false) pageSize:Int): ResponseEntity<PageDto<UniversityDto>> {
        val pageContent: PageDto<UniversityDto> = universityFacade.findAll(pageNumber, pageSize)
        return ResponseEntity(pageContent, HttpStatus.OK)
    }
}