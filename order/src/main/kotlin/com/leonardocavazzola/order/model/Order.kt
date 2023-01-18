package com.leonardocavazzola.order.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class Order(
    @Id
    val id: UUID = UUID.randomUUID(),
    status: Status = Status.CREATED,
    val items: List<Item>,
) {
    var status = status
        private set

    fun setAsPaidOut() = apply { status = Status.PAID_OUT }
}
