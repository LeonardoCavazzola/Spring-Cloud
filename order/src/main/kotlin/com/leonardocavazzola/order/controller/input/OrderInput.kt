package com.leonardocavazzola.order.controller.input

import com.leonardocavazzola.order.model.Order

data class OrderInput(
    val items: List<ItemInput>,
)

fun OrderInput.toEntity() = Order(
    items = items.toEntity()
)
