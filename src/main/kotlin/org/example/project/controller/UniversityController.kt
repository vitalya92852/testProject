package org.example.project.controller

import org.example.project.dto.PageDto
import org.example.project.dto.StudentDto
import org.example.project.dto.UniversityDto
import org.example.project.facade.UniversityFacade
import org.example.project.facade.impl.UniversityFacadeImpl
import org.example.project.request.CreateStudentRequestDto
import org.example.project.request.CreateUniversityRequestDto
import org.example.project.request.UpdateStudentRequestDto
import org.example.project.request.UpdateUniversityRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/university")
class UniversityController(
    private val universityFacade: UniversityFacadeImpl
) {
    @PostMapping()
    fun createUniversity(@RequestBody createUniversityRequestDto: CreateUniversityRequestDto): ResponseEntity<UniversityDto> {
        val universityDto = universityFacade.save(createUniversityRequestDto)
        return ResponseEntity(universityDto, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateUniversity(@PathVariable("id") id:Long, @RequestBody updateUniversityRequestDto: UpdateUniversityRequestDto): UniversityDto {
        return universityFacade.update(id,updateUniversityRequestDto)
    }

    @DeleteMapping("/{id}")
    fun deleteUniversity(@PathVariable("id") id:Long): ResponseEntity<Unit> {
        universityFacade.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/findAll")
    fun findAllPages(@RequestParam(defaultValue = "1", required = false) pageNumber:Int,
                     @RequestParam(defaultValue = "6", required = false) pageSize:Int): ResponseEntity<PageDto<UniversityDto>> {
        val pageContent: PageDto<UniversityDto> = universityFacade.findAll(pageNumber, pageSize)
        return ResponseEntity(pageContent, HttpStatus.OK)
    }
}