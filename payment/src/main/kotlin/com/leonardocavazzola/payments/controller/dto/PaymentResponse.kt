package com.leonardocavazzola.payments.controller.dto

import com.leonardocavazzola.payments.model.Payment
import com.leonardocavazzola.payments.model.Status
import java.math.BigDecimal
import java.util.*

data class PaymentResponse(
    val id: UUID,
    val value: BigDecimal,
    val orderId: UUID,
    val paymentMethodId: UUID,
    val status: Status = Status.CREATED,
)

fun Payment.toResponse() = PaymentResponse(
    id = id,
    value = value,
    status = status,
    orderId = orderId,
    paymentMethodId = paymentMethodId,
)

fun Collection<Payment>.toResponse() = map { it.toResponse() }
