package org.example.project.ipLogger

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Aspect
@Component
class IpAddress(
    private val logger:Logger = LoggerFactory.getLogger(IpAddress::class.java)
) {


    @Pointcut("execution(* org.example.project.web.controller.RoleController.helloStudent())")
    fun pointCutIpAddress(){}

    @Before("pointCutIpAddress()")
    fun getIpAddress(){
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?)!!.request
        logger.info(request.remoteAddr)
    }
}