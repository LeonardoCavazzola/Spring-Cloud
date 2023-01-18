package com.leonardocavazzola.payments.gateway

import java.math.BigDecimal

data class ItemOutput(
    val amount: BigDecimal,
    val name: String,
)
