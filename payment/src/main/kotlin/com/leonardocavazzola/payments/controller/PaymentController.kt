package com.leonardocavazzola.payments.controller

import com.leonardocavazzola.payments.controller.dto.PaymentInput
import com.leonardocavazzola.payments.controller.dto.PaymentResponse
import com.leonardocavazzola.payments.controller.dto.toEntity
import com.leonardocavazzola.payments.controller.dto.toResponse
import com.leonardocavazzola.payments.service.PaymentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/payments")
class PaymentController(
    private val paymentService: PaymentService
) {
    @GetMapping
    fun findAll(): List<PaymentResponse> = paymentService.findAll().toResponse()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID) = paymentService.findById(id).toResponse()

    @PostMapping
    fun create(@RequestBody payment: PaymentInput): PaymentResponse = paymentService.create(payment.toEntity()).toResponse()

    @PutMapping("/{id}/setAsConcluded")
    fun setAsConcluded(@PathVariable id: UUID): PaymentResponse = paymentService.setAsConcluded(id).toResponse()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): Unit = paymentService.delete(id)
}
