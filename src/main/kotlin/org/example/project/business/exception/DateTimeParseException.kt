package org.example.project.business.exception

import kz.sagengaliyev.univerbackend.exception.AbstractApplicationException
import org.springframework.http.HttpStatus

class DateTimeParseException(date:String): AbstractApplicationException(message = "Entity with ${date} not found") {
    override fun getStatus(): HttpStatus {
        return HttpStatus.BAD_REQUEST
    }

}