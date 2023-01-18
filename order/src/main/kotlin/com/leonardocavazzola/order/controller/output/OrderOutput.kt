package com.leonardocavazzola.order.controller.output

import com.leonardocavazzola.order.model.Order
import com.leonardocavazzola.order.model.Status
import java.util.*
import kotlin.collections.Collection

data class OrderOutput(
    val id: UUID,
    val status: Status,
    val items: List<ItemOutput>,
)

fun Order.toOutput() = OrderOutput(
    id = id,
    status = status,
    items = items.toOutput()
)

fun Collection<Order>.toOutput() = map { it.toOutput() }
