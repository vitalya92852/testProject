package org.example.project.web.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/role")
@Api(description = "Controller for testing roles")
class RoleController {
    @GetMapping("/student")
    @ApiOperation("Test pass for role student")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    fun helloStudent():ResponseEntity<Any>{
        return ResponseEntity(HttpStatus.OK)
    }
}