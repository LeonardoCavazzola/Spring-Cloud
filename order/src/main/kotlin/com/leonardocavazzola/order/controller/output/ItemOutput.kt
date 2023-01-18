package com.leonardocavazzola.order.controller.output

import com.leonardocavazzola.order.model.Item
import java.math.BigDecimal

data class ItemOutput(
    val amount: BigDecimal,
    val name: String,
)

fun Item.toOutput() = ItemOutput(
    amount = amount,
    name = name
)

fun Collection<Item>.toOutput() = map { it.toOutput() }
