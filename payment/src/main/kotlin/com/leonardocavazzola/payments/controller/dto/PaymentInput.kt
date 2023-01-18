package com.leonardocavazzola.payments.controller.dto

import com.leonardocavazzola.payments.model.Payment
import java.math.BigDecimal
import java.util.*

data class PaymentInput(
    val value: BigDecimal,
    val orderId: UUID,
    val paymentMethodId: UUID,
)

fun PaymentInput.toEntity() = Payment(
    value = value,
    orderId = orderId,
    paymentMethodId = paymentMethodId,
)
