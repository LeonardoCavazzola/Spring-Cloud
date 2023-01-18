package com.leonardocavazzola.order.controller

import com.leonardocavazzola.order.controller.input.OrderInput
import com.leonardocavazzola.order.controller.input.toEntity
import com.leonardocavazzola.order.controller.output.OrderOutput
import com.leonardocavazzola.order.controller.output.toOutput
import com.leonardocavazzola.order.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RequestMapping("/orders")
@RestController
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun findAll(): List<OrderOutput> = orderService.findAll().toOutput()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): OrderOutput = orderService.findById(id).toOutput()

    @PostMapping
    fun create(@RequestBody input: OrderInput): OrderOutput = orderService.create(input.toEntity()).toOutput()

    @PutMapping("/{id}/paid_out")
    fun setPaidOut(@PathVariable id: UUID): OrderOutput = orderService.setAsPaidOut(id).toOutput()
}
