package com.leonardocavazzola.order.controller.input

import com.leonardocavazzola.order.model.Item
import java.math.BigDecimal

data class ItemInput(
    val amount: BigDecimal,
    val name: String,
)

fun ItemInput.toEntity() = Item(
    amount = amount,
    name = name,
)

fun Collection<ItemInput>.toEntity() = map { it.toEntity() }
