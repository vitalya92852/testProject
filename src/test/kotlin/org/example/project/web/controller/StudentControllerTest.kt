package org.example.project.web.controller

import org.example.project.business.facade.StudentFacade
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock

class StudentControllerTest{
    @Mock
    private lateinit var studentFacade:StudentFacade
}