package org.example.project.exseption

import kz.sagengaliyev.univerbackend.exception.AbstractApplicationException
import org.springframework.http.HttpStatus

class EntityByIdNotFoundException(id:Long): AbstractApplicationException(message = "Entity with ${id} not found") {
    override fun getStatus(): HttpStatus {
        return HttpStatus.NOT_FOUND
    }
}