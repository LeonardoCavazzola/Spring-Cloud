package com.leonardocavazzola.payments.service

import com.leonardocavazzola.payments.gateway.OrderClient
import com.leonardocavazzola.payments.model.Payment
import com.leonardocavazzola.payments.repository.PaymentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val orderClient: OrderClient,
) {
    fun findAll() = paymentRepository.findAll()

    fun findById(id: UUID) = paymentRepository.findByIdOrNull(id) ?: throw Exception()

    fun create(payment: Payment) = paymentRepository.save(payment)

    fun delete(id: UUID) = paymentRepository.deleteById(id)

    fun setAsConcluded(id: UUID): Payment {
        val payment = findById(id)
        payment.setAsConcluded()
        paymentRepository.save(payment)

        orderClient.setPaidOut(payment.orderId)
        return payment
    }
}
