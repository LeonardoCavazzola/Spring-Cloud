package com.leonardocavazzola.payments.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*

@Document
class Payment(
    @Id
    val id: UUID = UUID.randomUUID(),
    val value: BigDecimal,
    val orderId: UUID,
    val paymentMethodId: UUID,
    status: Status = Status.CREATED,
) {
    var status: Status = status
        private set

    fun setAsConcluded() = apply { status = Status.CONCLUDED }
}
