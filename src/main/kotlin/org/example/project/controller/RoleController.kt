package org.example.project.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1/role")
class RoleController {
    @GetMapping("/student")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    fun helloStudent():ResponseEntity<Any>{
        return ResponseEntity(HttpStatus.OK)
    }
}