package com.leonardocavazzola.order.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/info")
class ServerController(

    @Value("\${eureka.instance.instance-id}") private val instanceId: String,
    @Value("\${spring.application.name}") private val applicationName: String,
) {
    @GetMapping
    fun get(
        @Value("\${local.server.port}") port: String
    ) = mapOf(
        "port" to port,
        "instance-id" to instanceId,
        "application-name" to applicationName,
    )
}
